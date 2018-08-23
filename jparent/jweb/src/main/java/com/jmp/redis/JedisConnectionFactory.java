package com.jmp.redis;

import redis.clients.jedis.Jedis;

public interface JedisConnectionFactory {
    /**
     * @description:获取Jedis连接；
     */
    Jedis getJedisConnection();

    /**
     * @description:关闭Jedis连接;
     */
    void closeJedisConnection(Jedis jedis);
}
