package com.jmp.redis;

import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JedisService extends Jedis {
    private JedisConnectionFactory jedisConnectionFactory;


    /**
     * 根据相应的TimeUnit设置有效时间
     *
     * @param key
     * @param value
     * @param num
     * @param unit
     * @return
     * @author samLai
     */
    public String set(String key, String value, int num, TimeUnit unit) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");
            String result = jedis.set(key, value);
            Long timeNum = unit.toSeconds(num);
            jedis.expire(key, timeNum.intValue());
            return result;
        }
    }

    @Override
    public String set(String key, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.set(key, value);
        }
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.set(key, value, nxxx, expx, time);
        }
    }

    @Override
    public String get(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.get(key);
        }
    }

    @Override
    public Long exists(String... keys) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.exists(keys);
        }
    }

    @Override
    public Boolean exists(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.exists(key);
        }
    }

    @Override
    public Long del(String... keys) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.del(keys);
        }
    }

    @Override
    public Long del(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.del(key);
        }
    }

    @Override
    public Long expire(String key, int seconds) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.expire(key, seconds);
        }
    }

    @Override
    public Long expireAt(String key, long unixTime) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.expireAt(key, unixTime);
        }
    }

    @Override
    public Long ttl(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.ttl(key);
        }
    }

    @Override
    public Long move(String key, int dbIndex) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.move(key, dbIndex);
        }
    }

    @Override
    public String getSet(String key, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.getSet(key, value);
        }
    }

    @Override
    public List<String> mget(String... keys) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.mget(keys);
        }
    }

    @Override
    public Long setnx(String key, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.setnx(key, value);
        }
    }

    @Override
    public String setex(String key, int seconds, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.setex(key, seconds, value);
        }
    }

    @Override
    public String mset(String... keysvalues) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.mset(keysvalues);
        }
    }

    @Override
    public Long msetnx(String... keysvalues) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.msetnx(keysvalues);
        }
    }

    @Override
    public Long decrBy(String key, long integer) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.decrBy(key, integer);
        }
    }

    @Override
    public Long decr(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.decr(key);
        }
    }

    @Override
    public Long incrBy(String key, long integer) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.incrBy(key, integer);
        }
    }

    @Override
    public Double incrByFloat(String key, double value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.incrByFloat(key, value);
        }
    }

    @Override
    public Long incr(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.incr(key);
        }
    }

    @Override
    public Long append(String key, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.append(key, value);
        }
    }

    @Override
    public String substr(String key, int start, int end) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.substr(key, start, end);
        }
    }

    @Override
    public Long hset(String key, String field, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hset(key, field, value);
        }
    }

    @Override
    public String hget(String key, String field) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hget(key, field);
        }
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hsetnx(key, field, value);
        }
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hmset(key, hash);
        }
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hmget(key, fields);
        }
    }

    @Override
    public Long hincrBy(String key, String field, long value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hincrBy(key, field, value);
        }
    }

    @Override
    public Double hincrByFloat(String key, String field, double value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hincrByFloat(key, field, value);
        }
    }

    @Override
    public Boolean hexists(String key, String field) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hexists(key, field);
        }
    }

    @Override
    public Long hdel(String key, String... fields) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hdel(key, fields);
        }
    }

    @Override
    public Long hlen(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hlen(key);
        }
    }

    @Override
    public Set<String> hkeys(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hkeys(key);
        }
    }

    @Override
    public List<String> hvals(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hvals(key);
        }
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hgetAll(key);
        }
    }

    @Override
    public Long rpush(String key, String... strings) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.rpush(key, strings);
        }
    }

    @Override
    public Long lpush(String key, String... strings) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.lpush(key, strings);
        }
    }

    @Override
    public Long llen(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.llen(key);
        }
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.lrange(key, start, end);
        }
    }

    @Override
    public String ltrim(String key, long start, long end) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.ltrim(key, start, end);
        }
    }

    @Override
    public String lindex(String key, long index) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.lindex(key, index);
        }
    }

    @Override
    public String lset(String key, long index, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.lset(key, index, value);
        }
    }

    @Override
    public Long lrem(String key, long count, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.lrem(key, count, value);
        }
    }

    @Override
    public String lpop(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.lpop(key);
        }
    }

    @Override
    public String rpop(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.rpop(key);
        }
    }

    @Override
    public String rpoplpush(String srckey, String dstkey) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.rpoplpush(srckey, dstkey);
        }
    }

    @Override
    public Long sadd(String key, String... members) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.sadd(key, members);
        }
    }

    @Override
    public Set<String> smembers(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.smembers(key);
        }
    }

    @Override
    public Long srem(String key, String... members) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.srem(key, members);
        }
    }

    @Override
    public String spop(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.spop(key);
        }
    }

    @Override
    public Set<String> spop(String key, long count) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.spop(key, count);
        }
    }

    @Override
    public Long smove(String srckey, String dstkey, String member) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.smove(srckey, dstkey, member);
        }
    }

    @Override
    public Long scard(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.scard(key);
        }
    }

    @Override
    public Boolean sismember(String key, String member) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.sismember(key, member);
        }
    }

    @Override
    public Set<String> sinter(String... keys) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.sinter(keys);
        }
    }

    @Override
    public String brpoplpush(String source, String destination, int timeout) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.brpoplpush(source, destination, timeout);
        }
    }

    @Override
    public Boolean setbit(String key, long offset, boolean value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.setbit(key, offset, value);
        }
    }

    @Override
    public Boolean setbit(String key, long offset, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.setbit(key, offset, value);
        }
    }

    @Override
    public Boolean getbit(String key, long offset) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.getbit(key, offset);
        }
    }

    @Override
    public Long setrange(String key, long offset, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.setrange(key, offset, value);
        }
    }

    @Override
    public String getrange(String key, long startOffset, long endOffset) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.getrange(key, startOffset, endOffset);
        }
    }

    @Override
    public Long bitpos(String key, boolean value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.bitpos(key, value);
        }
    }

    @Override
    public Long bitpos(String key, boolean value, BitPosParams params) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.bitpos(key, value, params);
        }
    }

    @Override
    public Object eval(String script, int keyCount, String... params) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.eval(script, keyCount, params);
        }
    }

    @Override
    public void subscribe(JedisPubSub jedisPubSub, String... channels) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            jedis.subscribe(jedisPubSub, channels);
        }
    }

    @Override
    public Long publish(String channel, String message) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.publish(channel, message);
        }
    }

    @Override
    public void psubscribe(JedisPubSub jedisPubSub, String... patterns) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            jedis.psubscribe(jedisPubSub, patterns);
        }
    }

    @Override
    public Object eval(String script, List<String> keys, List<String> args) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.eval(script, keys, args);
        }
    }

    @Override
    public Object eval(String script) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.eval(script);
        }
    }

    @Override
    public Long bitcount(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.bitcount(key);
        }
    }

    @Override
    public Long bitcount(String key, long start, long end) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.bitcount(key, start, end);
        }
    }

    @Override
    public Long bitop(BitOP op, String destKey, String... srcKeys) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.bitop(op, destKey, srcKeys);
        }
    }

    @Override
    public Long pexpire(String key, long milliseconds) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pexpire(key, milliseconds);
        }
    }

    @Override
    public Long pexpireAt(String key, long millisecondsTimestamp) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.expireAt(key, millisecondsTimestamp);
        }
    }

    @Override
    public Long pttl(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pttl(key);
        }
    }

    @Override
    public String psetex(String key, long milliseconds, String value) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.psetex(key, milliseconds, value);
        }
    }

    @Override
    public String set(String key, String value, String nxxx) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.set(key, value, nxxx);
        }
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, int time) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.set(key, value, nxxx, expx, time);
        }
    }

    @Override
    public ScanResult<String> scan(String cursor) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.scan(cursor);
        }
    }

    @Override
    public ScanResult<String> scan(String cursor, ScanParams params) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.scan(cursor, params);
        }
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hscan(key, cursor);
        }
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.hscan(key, cursor, params);
        }
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.sscan(key, cursor);
        }
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.sscan(key, cursor, params);
        }
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.zscan(key, cursor);
        }
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.zscan(key, cursor, params);
        }
    }

    @Override
    public List<String> pubsubChannels(String pattern) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pubsubChannels(pattern);
        }
    }

    @Override
    public Long pubsubNumPat() {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pubsubNumPat();
        }
    }

    @Override
    public Map<String, String> pubsubNumSub(String... channels) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pubsubNumSub(channels);
        }
    }

    @Override
    public Long pfadd(String key, String... elements) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pfadd(key, elements);
        }
    }

    @Override
    public long pfcount(String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pfcount(key);
        }
    }

    @Override
    public long pfcount(String... keys) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pfcount(keys);
        }
    }

    @Override
    public String pfmerge(String destkey, String... sourcekeys) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.pfmerge(destkey, sourcekeys);
        }
    }

    @Override
    public List<String> blpop(int timeout, String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.blpop(timeout, key);
        }
    }

    @Override
    public List<String> brpop(int timeout, String key) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.brpop(timeout, key);
        }
    }

    @Override
    public Long geoadd(String key, double longitude, double latitude, String member) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.geoadd(key, longitude, latitude, member);
        }
    }

    @Override
    public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.geoadd(key, memberCoordinateMap);
        }
    }

    @Override
    public Double geodist(String key, String member1, String member2) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.geodist(key, member1, member2);
        }
    }

    @Override
    public Double geodist(String key, String member1, String member2, GeoUnit unit) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.geodist(key, member1, member2, unit);
        }
    }

    @Override
    public List<String> geohash(String key, String... members) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.geohash(key, members);
        }
    }

    @Override
    public List<GeoCoordinate> geopos(String key, String... members) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.geopos(key, members);
        }
    }

    @Override
    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.georadius(key, longitude, latitude, radius, unit);
        }
    }

    @Override
    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.georadius(key, longitude, latitude, radius, unit, param);
        }
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.georadiusByMember(key, member, radius, unit);
        }
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.georadiusByMember(key, member, radius, unit, param);
        }
    }

    @Override
    public List<Long> bitfield(String key, String... arguments) {
        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
            Objects.requireNonNull(jedis, "获取redis数据库连接失败");

            return jedis.bitfield(key, arguments);
        }
    }


//    /**
//     * 获取当个对象 【泛型内容】
//     * */
//    public <T> T get(String key,  Class<T> clazz) {
//        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
//            Objects.requireNonNull(jedis, "获取redis数据库连接失败");
//
//            String  str = jedis.get(key);
//            T t =  stringToBean(str, clazz);
//            return t;
//        }
//    }
//
//
//    /**
//     * 设置对象
//     * */
//    public <T> boolean set(String key,  T value) {
//        try (Jedis jedis = jedisConnectionFactory.getJedisConnection()) {
//            Objects.requireNonNull(jedis, "获取redis数据库连接失败");
//            String str = beanToString(value);
//            if(str == null || str.length() <= 0)
//                return false;
//            jedis.set(key, str);
//            return true;
//        }
//    }



    /**
     * 根据对应的string内容返回java bean内容
     * @param str
     * @param clazz
     * @param <T>
     * @return
     */
//    public static <T> T stringToBean(String str, Class<T> clazz) {
//        if(str == null || str.length() <= 0 || clazz == null) {
//            return null;
//        }
//        if(clazz == int.class || clazz == Integer.class) {
//            return (T)Integer.valueOf(str);
//        }else if(clazz == String.class) {
//            return (T)str;
//        }else if(clazz == long.class || clazz == Long.class) {
//            return  (T)Long.valueOf(str);
//        }else {
//            return JSON.toJavaObject(JSON.parseObject(str), clazz);
//        }
//    }


    /**
     * 根据javabean返回字符内容
     * @param value
     * @param <T>
     * @return
     */
//    public static <T> String beanToString(T value) {
//        if(value == null) {
//            return null;
//        }
//        Class<?> clazz = value.getClass();
//        if(clazz == int.class || clazz == Integer.class) {
//            return ""+value;
//        }else if(clazz == String.class) {
//            return (String)value;
//        }else if(clazz == long.class || clazz == Long.class) {
//            return ""+value;
//        }else {
//            return JSON.toJSONString(value);
//        }
//    }


    public JedisConnectionFactory getJedisConnectionFactory() {
        return jedisConnectionFactory;
    }

    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        this.jedisConnectionFactory = jedisConnectionFactory;
    }

}

