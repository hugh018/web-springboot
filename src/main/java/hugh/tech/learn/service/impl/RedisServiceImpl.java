package hugh.tech.learn.service.impl;

import hugh.tech.learn.entity.User;
import hugh.tech.learn.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author: hugh
 * Created on 2019/2/10
 * func:
 * params:
 * link: https://www.cnblogs.com/skyessay/p/6485187.html
 */
@Service
public class RedisServiceImpl implements RedisService<User> {

    private static final String REDIS_KEY = "REDIS_KEY_TEST"; // map的数据结构

    @Autowired
    private StringRedisTemplate stringRedisTemplate; // <String, String>

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    /**
     * [id,map]=(redis-data-id,map<K,V>)
     */
    @Resource
    private HashOperations<String, String, User> hashOperations;

    @Autowired
    private ValueOperations valueOperations;


    @Override
    public void setString(String key, String value) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value);
    }

    @Override
    public String getByKeyString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void deleteString(String key) {
        stringRedisTemplate.delete(key);
    }

    //============object================//
    @Override
    public String getRedisKey() {
        return REDIS_KEY;
    }

    @Override
    public void put(String key, User domain, long expire) {
        hashOperations.put(getRedisKey(), key, domain);
//        redisTemplate.opsForHash().put(getRedisKey(), key, domain);
//        redisTemplate.opsForValue().set(key, domain);
//        valueOperations.set(key, domain);
        if (expire != -1) {
            redisTemplate.expire(getRedisKey(), expire, TimeUnit.SECONDS);
        }
    }

    @Override
    public void remove(String key) {
        hashOperations.delete(getRedisKey(), key);
    }

    @Override
    public User get(String key) {
        return hashOperations.get(getRedisKey(), key);
    }

    @Override
    public List<User> getAll() {
        return hashOperations.values(getRedisKey());
    }

    @Override
    public Set<String> getKeys() {
        return hashOperations.keys(getRedisKey());
    }

    @Override
    public boolean isKeyExists(String key) {
        return hashOperations.hasKey(getRedisKey(), key);
    }

    @Override
    public long cnt() {
        return hashOperations.size(getRedisKey());
    }

    @Override
    public void empty() {
        Set<String> todoDelete = hashOperations.keys(getRedisKey());
        for (String k : todoDelete) {
            hashOperations.delete(getRedisKey(), k);
        }
    }

}
