package com.dubbo.service.redis.impl;

import com.dubbo.service.redis.JedisConnectionFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Objects;

/**
 * @author samLai
 * @date 2018/12/13 16:03
 * @Description : redis的服务类内容
 */
public class JedisConnectionFactoryImpl implements JedisConnectionFactory {


    private static final Logger LOGGER = LoggerFactory.getLogger(JedisConnectionFactoryImpl.class);
    /**
     * redis数据库服务器地址;
     */
    private String host;
    /**
     * redis数据库服务器端口;
     */
    private Integer port;
    /**
     * redis数据库服务器登录密码;
     */
    private String password;
    /**
     * 连接超时时间,单位:ms;
     */
    private Integer timeout;
    /**
     * 连接池配置信息;
     */
    private GenericObjectPoolConfig poolConfig;
    /**
     * redis数据库连接池对象;
     */
    private JedisPool jedisPool;

    public JedisConnectionFactoryImpl() {}

    /**
     * @description:启动Jedis连接池;
     */
    public void init() {
        Objects.requireNonNull(host, "redis数据库服务器地址不能为空");
        Objects.requireNonNull(port, "redis数据库服务器端口不能为空");
        Objects.requireNonNull(poolConfig, "redis数据库连接池配置信息不能为空");

        // 初始化连接池;
        if(jedisPool == null) {
            jedisPool = new JedisPool(poolConfig, host, port, timeout, password);
        }
        Objects.requireNonNull(jedisPool, "启动redis数据库连接池失败");
        LOGGER.info("启动redis数据库连接池成功");
    }

    /**
     * @description:关闭Jedis连接池;
     */
    public void destroy() {
        if(jedisPool != null) {
            jedisPool.destroy();
        }
        LOGGER.info("关闭redis数据库连接池成功");
    }

    @Override
    public Jedis getJedisConnection() {
        return this.jedisPool.getResource();
    }

    @Override
    public void closeJedisConnection(Jedis jedis) {
        if(jedis != null) {
            jedis.close();
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public GenericObjectPoolConfig getPoolConfig() {
        return poolConfig;
    }

    public void setPoolConfig(GenericObjectPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }

}
