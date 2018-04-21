package jielin.snapshot.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jielin.snapshot.common.JedisUtil;
import jielin.snapshot.dao.DeploymentDao;
import jielin.snapshot.domain.DeploymentDataProdEntity;
import jielin.snapshot.domain.DeploymentMiddleObj;
import org.slf4j.LoggerFactory;
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
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MigrationTask.class);
    @Autowired
    private JedisUtil util;

    @Autowired
    private DeploymentDao dao;


    @Scheduled(cron="0 0,10,20,30,40,50 * * * *")
    public void executeDataSyncTask() {
        logger.info("同步mysql新增数据");

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
        },new Sort(Sort.Direction.ASC,"id"));

        intoRedis(list);
        logger.info("=======数据同步成功=======");
    }

    private void intoRedis(List<DeploymentDataProdEntity> list) {
        if (list.size()==0){
            logger.info("===========没有数据更新==========");
            return;
        }
        logger.info("========更新数据条数："+list.size());
        Jedis jedis=util.getConn();
        int newBiggestId = JedisUtil.getGretestId();
        DeploymentMiddleObj obj=null;
        for (DeploymentDataProdEntity d:list
                ) {
            obj = d.toMiddle();
            String id =obj.id;
            String type = d.getType().toUpperCase();
            String cluster = d.getLocation();
            jedis.zadd(type,jedis.zcount(type,0,200000)+1,
                    id);
            jedis.zadd(cluster,jedis.zcount(cluster,0,200000)+1,
                    id);
            jedis.zadd( "all_data_id",jedis.zcount(
                    "all_data_id",0,200000)+1,id);
            ObjectMapper mapper =new ObjectMapper();

            Map<String,String > map = mapper.convertValue(obj,Map.class);
            jedis.hmset(id,map);

            newBiggestId = d.getId();
        }
        JedisUtil.setGretestId(newBiggestId);
        JedisUtil.close(jedis);
    }

    @Scheduled(cron="0 20 9 21 4 *")
    public void executeInitRedis(){
        logger.info("=========清空redis db======");
        Jedis jedis =util.getConn();
        jedis.flushDB();
        logger.info("=========开始从mysql获取初始数据========");
        List<DeploymentDataProdEntity> list =
                dao.findAll(new Sort(Sort.Direction.ASC,"id"));
        logger.info("=========获取数据,准备存入redis=========");

        intoRedis(list);
        logger.info("==========数据初始拷贝成功============");
    }
}
