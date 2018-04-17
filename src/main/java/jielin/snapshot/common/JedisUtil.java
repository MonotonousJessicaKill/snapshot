package jielin.snapshot.common;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
    @Autowired
    private static JedisPool jedisPool;
    private static int gretestId;

    public static Jedis getConn(){
        return jedisPool.getResource();
    }
    public static void close(Jedis jedis){
        jedis.close();
    }

    public static int getGretestId() {
        return gretestId;
    }

    public static void setGretestId(int gretestId) {
        JedisUtil.gretestId = gretestId;
    }
}
