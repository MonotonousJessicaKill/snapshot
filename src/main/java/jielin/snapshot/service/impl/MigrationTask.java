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
import java.util.Set;

/**
 * @Author: jielin.wu wu.jielin@oe.21vianet.com
 * @CreateTime: 2018/4/27
 * Description:
 */
@Component
public class MigrationTask {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MigrationTask.class);
    @Autowired
    private JedisUtil util;

    @Autowired
    private DeploymentDao dao;


    @Scheduled(cron="0 0,10,20,30,40,50 * * * *")
    public void executeDataSyncTask() {
        Jedis jedis=util.getConn();
        logger.info("========准备同步mysql新增数据=========");
        if (JedisUtil.getGretestId() == 0){
            jedis.flushDB();
        }
        List<DeploymentDataProdEntity> list = dao.findAll(new Specification<DeploymentDataProdEntity>() {
            @Override
            public Predicate toPredicate(Root<DeploymentDataProdEntity> root,
                                         CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {


                Predicate greaters=      criteriaBuilder.greaterThan(root.get("id"),
                                JedisUtil.getGretestId());

                Predicate notLikes =  criteriaBuilder.and(criteriaBuilder.notLike(root.get("title"),
                        "%HelloWorld%"));
               criteriaQuery.where(greaters,notLikes);

                return null;
            }
        },new Sort(Sort.Direction.ASC,"id"));

        intoRedis(list,jedis);
        logger.info("=======数据同步成功=======");
    }
    @Scheduled(cron="0 5,15,25,35,45,55 * * * *")
    public void executeUpdateStatus(){
        logger.info("===============准备更新部署状态==========");
        Jedis jedis = util.getConn();
        executeUpdateStatus(jedis,"PENDING");
        executeUpdateStatus(jedis,"DEPLOYING");
        executeUpdateStatus(jedis,"BLOCKED");
        executeUpdateStatus(jedis,"AWAITING DEPLOYMENT");
        logger.info("===============部署状态更新结束==========");
    }

    private void executeUpdateStatus(Jedis jedis, String stateInRedis) {
        Set<String> set =jedis.zrange(stateInRedis,0,200000);
        int count = 0;
        for (String id: set
                ) {
            DeploymentDataProdEntity entity = dao.findOne(Integer.parseInt(id));
            DeploymentMiddleObj obj = entity.toMiddle();
            String newState = entity.getTaskState();
            if (!(newState.toUpperCase()).equals(stateInRedis)){
                jedis.zadd(newState.toUpperCase(),jedis.zcount(newState.toUpperCase(),0,200000)+1,
                        id);
                jedis.zrem(stateInRedis,id);

                jedis.hset(id,"taskState",newState);
                count++;
            }
        }
        if (count>0){
            logger.info("==========="+stateInRedis+"数据已经更新："+count+"条===========");
            rerankStateSet(stateInRedis,jedis);
        }else {
            JedisUtil.close(jedis);
        }

    }

    private void rerankStateSet(String stateInRedis, Jedis jedis) {
        Set<String> set =jedis.zrange(stateInRedis,0,200000);
        jedis.zremrangeByScore(stateInRedis,0,200000);
        for (String id:set
             ) {
            jedis.zadd(stateInRedis,jedis.zcount(stateInRedis,0,200000)+1,
                    id);
        }
        JedisUtil.close(jedis);

    }

    private void intoRedis(List<DeploymentDataProdEntity> list,Jedis jedis) {
        if (list.size()==0){
            logger.info("===========没有新增部署==========");
            return;
        }
        logger.info("========待新增数据条数："+list.size());

        int newBiggestId = JedisUtil.getGretestId();
        DeploymentMiddleObj obj=null;
        for (DeploymentDataProdEntity d:list
                ) {
            obj = d.toMiddle();
            String id =obj.id;
            String type = d.getType().toUpperCase();
            String state = d.getTaskState().toUpperCase();

            //****************
            String cluster = d.getLocation().toUpperCase();
            jedis.zadd(type,jedis.zcount(type,0,200000)+1,
                    id);
            jedis.zadd(cluster,jedis.zcount(cluster,0,200000)+1,
                    id);
            jedis.zadd(state,jedis.zcount(state,0,200000)+1,
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
}
