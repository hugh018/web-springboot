package hugh.tech.learn.controller;

import hugh.tech.learn.entity.User;
import hugh.tech.learn.mapper.UserMapper;
import hugh.tech.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * @author: hugh
 * Created on 2019/2/7
 * func:
 * params:
 * link:
 */

@RestController
@RequestMapping("/mybatis")
public class mybatisController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("insert")
    public String insert() {
        int res = userMapper.insert("胡松", "female");
        return String.valueOf(res);
    }

    @RequestMapping("insertByMap")
    public HashMap<String, Object> insertMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "nameByMap");
        map.put("sex", "maleByMap");
        userMapper.insertByMap(map);
        return map;
    }

    @RequestMapping("insertByMObj")
    public int insertObj() {
        User user = new User();
        user.setName("hughObg");
        user.setSex("maleObj");
        return userMapper.insertByObj(user);
    }

    @RequestMapping("/update")
    public void update() {
        User user = new User();
        user.setName("hugh");
        user.setSex("男");
        userMapper.update(user);
    }

    @RequestMapping("/delete")
    public void delete() {
        userMapper.delete(10L);
    }

    @RequestMapping("/find")
    public List<User> findByName(String name) {
        List<User> res = userMapper.findByName(name);
        return res;
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        List<User> res = userMapper.findAll();
        return res;
    }

    @RequestMapping("/findById")
    public User findAll(Long id) {
        User res = userService.findById(id);
        return res;
    }

    @RequestMapping("/selectAll")
    public Object selectAll(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize) {

        return userService.selectAll(pageNum, pageSize);
    }

    @RequestMapping("/deleteById")
    public String deleteById(Long id) {

        try {
            userService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "delete fail";
        }
        return "delete ok";
    }
}
