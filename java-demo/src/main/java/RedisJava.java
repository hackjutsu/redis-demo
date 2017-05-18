import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisJava {

    public static void main(String[] args) {
//        redis_single_thread();
        redis_multi_threads();
    }

    private static void redis_single_thread() {
        Jedis jedis = new Jedis();

        jedis.set("foo", "bar");
        String cachedResponse1 = jedis.get("foo");
        System.out.println(cachedResponse1);


        jedis.setex("foo_exp", 10, "bar_exp");
        String cachedResponse2 = jedis.get("foo_exp");
        System.out.println(cachedResponse2);

        jedis.close();
    }

    private static void redis_multi_threads() {
        // Default to 8 connections
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            /// ... do stuff here ... for example
            jedis.set("foo_pool", "bar_pool");
            String foobar = jedis.get("foo_pool");

            System.out.println(foobar);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        /// ... when closing your application:
        pool.destroy();
    }
}
