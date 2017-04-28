package com.imooc.mvcdemo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zwb on 17/4/26.
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 方式执行之前会被执行，需要在pring_mvc.xml中配置
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return true 表示不拦截，往下执行  false表示拦截，不往下执行
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
