package hugh.tech.learn.intercetor;

import hugh.tech.learn.entity.User;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: hugh
 * Created on 2019/2/10
 * func:
 * params:
 * link:
 */
@Component
public class UserIntercetor implements HandlerInterceptor {

    /*
     * 进入controller层之前拦截请求
     * 返回值：表示是否将当前的请求拦截下来  false：拦截请求，请求终止。true：请求不被拦截，继续执行
     * Object obj:表示被拦的请求的目标对象（controller中方法）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了preHandle方法");
        System.out.println("请求的目标是：" + handler);
        User user = (User) request.getSession().getAttribute("session_user");
        if (null == user) { // 没有登录
            response.sendRedirect(request.getContextPath() + "/user/toIndex");
            System.out.println("成功拦截并且转发跳转");
            return false;
        }
        System.out.println("放行，不需要拦截");
        return true;
    }

    /*
     * 处理请求完成后视图渲染之前的处理操作
     * 通过ModelAndView参数改变显示的视图，或发往视图的方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("执行了postHandle方法");
    }

    /**
     * 视图渲染之后的操作
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("执行了afterCompletion方法");
    }

}


//public class OneInterceptor implements HandlerInterceptor  {
//
////	*
////	 * 在请求处理之前进行调用（Controller方法调用之前）
//@Override
//public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//                         Object object) throws Exception {
//
//    System.out.println("被one拦截，放行...");
//    return true;
//
//		/*if (true) {
//			returnErrorResponse(response, IMoocJSONResult.errorMsg("被one拦截..."));
//		}
//
//		return false;*/
//}
//
////    *
////     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response,
//                           Object object, ModelAndView mv)
//            throws Exception {
//        // TODO Auto-generated method stub
//
//    }
//
////    /**
////     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行
////     * （主要是用于进行资源清理工作）
////     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
//                                Object object, Exception ex)
//            throws Exception {
//        // TODO Auto-generated method stub
//
//    }
//
//    public void returnErrorResponse(HttpServletResponse response, IMoocJSONResult result)
//            throws IOException, UnsupportedEncodingException {
//        OutputStream out=null;
//        try{
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("text/json");
//            out = response.getOutputStream();
//            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
//            out.flush();
//        } finally{
//            if(out!=null){
//                out.close();
//            }
//        }
//    }
//}
