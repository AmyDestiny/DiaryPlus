package com.gentlehu.diary.interceptor;

import com.gentlehu.diary.controller.DiaryController;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DiaryInterceptor implements HandlerInterceptor{

    private static Logger logger = Logger.getLogger(DiaryInterceptor.class);
    /**
     * 将要执行 true 表示放行，false表示拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("preHandle>>>>>>>>");
        //拦截insert和delete操作。验证密码
        if(handler instanceof DiaryController && (uri.indexOf("insert")!=-1 || uri.indexOf("delete")!=-1)){
            String password =  request.getParameter("password");
            if(password == null || !password.equals("819548948")){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("code", 404);
                map.put("msg", "密码不正确！！");
                //这句话的意思，是让浏览器用utf8来解析返回的数据
                response.setHeader("Content-type", "text/html;charset=UTF-8");
                //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859-1
                response.setCharacterEncoding("UTF-8");
                String json = new Gson().toJson(map);
                try {
                    response.getWriter().write(json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                logger.info("拦截|uri="+uri +"&password="+password);
                return false;
            }
        }
        return true;
    }

    /**
     * 视图解析完毕，将要返回给用户
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){
            modelAndView.addObject("testdata", "HAlisa");
        }
        System.out.println("postHandle>>>>>>>>");
    }

    /**
     * 视图已经被解析完毕。为了捕捉到页面的异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("afterCompletion>>>>>>>>");
    }

}