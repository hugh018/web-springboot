package hugh.tech.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: hugh
 * Created on 2019/2/7
 * func:
 * params:
 * link:
 */

@RestController
@RequestMapping("/test")
public class testController {

    @RequestMapping("/hello")
    public String hello(String value) {
        return "hello " + value;
    }
}
