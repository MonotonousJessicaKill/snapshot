package jielin.snapshot.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import jielin.snapshot.common.JedisUtil;
import jielin.snapshot.dao.DeploymentDao;
import jielin.snapshot.domain.DeploymentDataProdEntity;
import jielin.snapshot.domain.DeploymentMiddleObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;


@Component
public class MigrationTask {
    @Autowired
    private JedisUtil util;

    @Autowired
    private DeploymentDao dao;


    @Scheduled(cron="0 30 * * * *")
    public void executeDataSyncTask() {


        List<DeploymentDataProdEntity> list = dao.findAll(new Specification<DeploymentDataProdEntity>() {
            @Override
            public Predicate toPredicate(Root<DeploymentDataProdEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {

                Predicate greaters =
                        criteriaBuilder.greaterThan(root.get("id"), JedisUtil.getGretestId());
                criteriaQuery.where(greaters);
                return null;
            }
        });

        intoRedis(list);

    }

    private void intoRedis(List<DeploymentDataProdEntity> list) {

        Jedis jedis=util.getConn();
        int newBiggestId = 0;
        for (DeploymentDataProdEntity d:list
                ) {
            DeploymentMiddleObj obj = d.toMiddle();
            String id =obj.id;
            String type = d.getType();
            String cluster = d.getLocation();
            jedis.zadd(type,jedis.zcount(type,0,200000)+1,
                    id);
            jedis.zadd(cluster,jedis.zcount(type,0,200000)+1,
                    id);
            jedis.zadd( "all_data_id",jedis.zcount(
                    "all_data_id",0,20000)+1,id);
            ObjectMapper mapper =new ObjectMapper();

            Map<String,String > map = mapper.convertValue(obj,Map.class);
            jedis.hmset(id,map);

            newBiggestId = d.getId();
        }
        JedisUtil.setGretestId(newBiggestId);
        JedisUtil.close(jedis);
    }

    @Scheduled(cron="0 57 12 18 4 *")
    public void executeInitRedis(){
        System.out.println("进入init task");
        List<DeploymentDataProdEntity> list =
                dao.findAll(new Sort(Sort.Direction.ASC,"id"));
        System.out.println("取得数据");

        intoRedis(list);
        System.out.println("存放成功");
    }
}
