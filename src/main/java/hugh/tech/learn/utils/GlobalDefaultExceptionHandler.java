package hugh.tech.learn.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: hugh
 * Created on 2019/2/11
 * func:
 * params:
 * link:
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * 字符串或者json的返回。  modelAndView没有实现
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("全局异常： " + e.getMessage());
        e.printStackTrace();
        return "对不起，服务器繁忙，请稍后再试";
    }

}
