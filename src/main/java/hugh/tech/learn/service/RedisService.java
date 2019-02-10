package hugh.tech.learn.service;


import java.util.List;
import java.util.Set;

/**
 * @author: hugh
 * Created on 2019/2/10
 * func:
 * params:
 * link:
 */
public interface RedisService<T> {

    void setString(String key, String value);

    String getByKeyString(String key);

    void deleteString(String key);

    //============object================//
    String getRedisKey();

    /**
     * @param key map-->key
     * @param domain 对象
     * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
     */
    void put(String key, T domain, long expire);

    void remove(String key);

    T get(String key);

    List<T> getAll(); // 获取当前库中所有的对象

    Set<String> getKeys(); // 获取所有的key

    boolean isKeyExists(String key);

    long cnt();

    void empty();

}
