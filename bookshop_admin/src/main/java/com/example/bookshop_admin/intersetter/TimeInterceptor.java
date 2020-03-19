package com.example.bookshop_admin.intersetter;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
      System.out.println(((HandlerMethod)handler).getMethod().getName());

      request.setAttribute("startTime", new Date().getTime());
      System.out.println("这里是 preHandle");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
      System.out.println("这里是 postHandle ");
      System.out.println("服务器处理耗时："+(new Date().getTime() - (Long)request.getAttribute("startTime"))+"ms");
  }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
       System.out.println("这里是 afterCompletion ");
       System.out.println("服务器处理耗时："+(new Date().getTime() - (Long)request.getAttribute("startTime"))+"ms");
       System.out.println("ex is "+ex);
    }
}
