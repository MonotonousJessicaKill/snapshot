package jielin.snapshot.service.impl;


import jielin.snapshot.ResultUtil;
import jielin.snapshot.common.JedisUtil;
import jielin.snapshot.common.Result;
import jielin.snapshot.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis规则：
 * 使用zset进行存储id，使用hash存储记录
 * zset键值采用type，cluster，version
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private JedisUtil util;

    @Override
    public Result searchDeploymentByTitle(String key, int pageNo) {
        if ("ALL".equals(key)){
                key = "all_data_id";
        }
        Jedis jedis=util.getConn();
        if (jedis==null){
            return ResultUtil.error("连接资源不足");
        }
        if(key.matches("[0-9]+")){
            return searchById(key,jedis);
        }
        return searchAll(key,pageNo,jedis);
    }

    private Result searchById(String key,Jedis jedis) {
        List<Map<String,String>> list=new ArrayList<>();
        Map<String,String> map=jedis.hgetAll(key);
        list.add(map);
        JedisUtil.close(jedis);
        return ResultUtil.success(list,1+"");
    }

    private Result searchAll(String key, int pageNo,Jedis jedis) {

        long top = jedis.zcount(key,0,200000);
        long start = top - pageNo*10;
        long end = top - pageNo*10-9;
        List<Map<String,String>> list=new ArrayList<>();
        if (!jedis.exists(key)) {
            JedisUtil.close(jedis);
            return ResultUtil.error("没有查找的key值");
        }
        Set<String> set=
                jedis.zrevrangeByScore(key,start,end);
        for (String id:
                set) {
            Map<String,String> m=jedis.hgetAll(id);
            list.add(m);
        }

        JedisUtil.close(jedis);
        return ResultUtil.success(list,(top+1)/10+"");

    }
}
