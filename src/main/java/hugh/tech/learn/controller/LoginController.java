package hugh.tech.learn.controller;

import hugh.tech.learn.entity.User;
import hugh.tech.learn.mapper.UserMapper;
import hugh.tech.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
@RequestMapping("/user")
public class LoginController {


    @Autowired
    private UserService userService;

    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        String name = user.getName();
        String sex = user.getSex();
        User res = userService.login(name, sex);

        if (res == null) {
            return "用户名或者密码错误";
        } else {
            // 登录成功后，将user加入session中，用于拦截
            request.getSession().setAttribute("session_user", user);
            return "登录成功";
        }
    }

    @RequestMapping("/toRegister")
    public ModelAndView toRegister() {
        return new ModelAndView("register");
    }

    @RequestMapping("/register")
    public ModelAndView register(User user) {
        int res = userService.register(user);
        if (1 == res) {
            System.out.println("注册成功");
        }
        return new ModelAndView("welcome");
    }


    //测试未登陆拦截页面
    @RequestMapping("/welcome")
    public ModelAndView welocme() {
        return new ModelAndView("welcome");
    }

    // 推出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/toIndex");
    }


}
