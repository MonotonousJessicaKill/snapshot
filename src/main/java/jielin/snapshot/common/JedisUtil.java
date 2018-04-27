package jielin.snapshot.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisUtil {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(JedisUtil.class);
    @Autowired
    private JedisPool jedisPool;

    private static int gretestId;

    public  Jedis getConn() {
        try {
            if (jedisPool != null)
                return jedisPool.getResource();
            else return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        } finally {
            logger.info("目前jedisPool中Active连接数目：" + getActiveConn());
        }

    }

    public static void close(Jedis jedis) {
        if (jedis != null)
            jedis.close();
    }

    public int getActiveConn() {
        return jedisPool.getNumActive();
    }

    public static int getGretestId() {
        return gretestId;
    }

    public static void setGretestId(int gretestId) {
        JedisUtil.gretestId = gretestId;
    }
}
