package jielin.snapshot.service.impl;


import com.alibaba.fastjson.JSON;
import jielin.snapshot.common.JedisUtil;
import jielin.snapshot.service.SearchService;
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
    @Override
    public String searchDeploymentByTitle(String key, int pageNo) {
        if (key == null){
                key = "all_data_id";
        }
        return searchAll(key,pageNo);
    }

    private String searchAll(String key, int pageNo) {
        Jedis jedis=JedisUtil.getConn();
        List<Map<String,String>> list=new ArrayList<>();
        if (!jedis.exists(key))return null;
        Set<String> set= jedis.zrevrange("all_data_id",pageNo*10+1,pageNo*10+10);
        for (String id:
             set) {

            Map<String,String> m=jedis.hgetAll(id);
            list.add(m);
        }
        JedisUtil.close(jedis);
        return JSON.toJSONString(list);
    }
}
