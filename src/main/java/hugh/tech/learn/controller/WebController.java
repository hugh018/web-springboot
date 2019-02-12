package hugh.tech.learn.controller;

import hugh.tech.learn.entity.User;
import hugh.tech.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: hugh
 * Created on 2019/2/7
 * func:
 * params:
 * link:
 */

@RestController
@RequestMapping("/web")
public class WebController {


    @RequestMapping("/test_param1")
    public ModelAndView test_param1(String name, Integer age) {
        Map<String, Object> map = new HashMap<>(); // 页面参数
        map.put("name", name);
        map.put("age", age);
        return new ModelAndView("test_param1", map);
    }

}
