package hugh.tech.learn.intercetor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hugh
 * Created on 2019/2/10
 * func:
 * params:
 * link:
 */
@Configuration
public class SessionInterceptor implements WebMvcConfigurer {

    /**
     * 自定义拦截器，添加拦截路径和排除拦截路径
     * addPathPatterns():添加需要拦截的路径
     * excludePathPatterns():添加不需要拦截的路径
     */
    //注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        List list = new ArrayList(); //放行的4个请求
//        list.add("/user/toIndex");
//        list.add("/user/login");
//        list.add("/user/toRegister");
//        list.add("/user/register");
//        registry.addInterceptor(new UserIntercetor()).addPathPatterns("/**").excludePathPatterns(list); // only interception welcome
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        /**
//         * 拦截器按照顺序执行
//         */
//        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
//                .addPathPatterns("/one/**");
//        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
//
//        super.addInterceptors(registry);
//    }

}
