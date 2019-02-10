package hugh.tech.learn.controller;

import hugh.tech.learn.entity.User;
import hugh.tech.learn.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: hugh
 * Created on 2019/2/10
 * func:
 * params:
 * link:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/set")
    public void set(String key, String value) {
        redisService.setString(key, value);
    }

    @RequestMapping("/getByKeyString")
    public String getByKeyString(String key) {
        return redisService.getByKeyString(key);
    }

    @RequestMapping("/remove_string")
    public void remove(String key) {
        redisService.deleteString(key);
    }

    //=============object=================//
    @RequestMapping("/add")
    public void add() {
        System.out.println("add start.....");
        User user1 = new User();
        user1.setId(1L);
        user1.setName("hugh11");
        user1.setSex("male");
        redisService.put(user1.getName(), user1, -1);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("hugh12");
        user2.setSex("male");
        redisService.put(user2.getName(), user2, -1);

        User user3 = new User();
        user3.setId(3L);
        user3.setName("hugh13");
        user3.setSex("male");
        redisService.put(user3.getName(), user3, -1);

        System.out.println("add end.....");
    }

    @RequestMapping("/getAll")
    public Object getAll() {
        return redisService.getAll();
    }

    //查询所有key
    @RequestMapping(value = "/getKeys")
    public Object getKeys() {
        return redisService.getKeys();
    }

    //根据key查询
    @RequestMapping(value = "/get")
    public Object get() {
        return redisService.get("hugh3");
    }

    //删除
    @RequestMapping(value = "/remove")
    public void remove() {
        redisService.remove("hugh1");
    }

    //判断key是否存在
    @RequestMapping(value = "/isKeyExists")
    public boolean isKeyExists(String key) {
        boolean res = redisService.isKeyExists(key);
        System.out.println(key + " 是否存在: " + res);
        return res;
    }


    @RequestMapping(value = "/cnt")
    public long cnt() {
        return redisService.cnt();
    }

    @RequestMapping(value = "/empty")
    public void empty() {
        redisService.empty();
    }

}
