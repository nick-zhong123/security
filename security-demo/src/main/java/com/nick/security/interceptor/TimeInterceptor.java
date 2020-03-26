package com.nick.security.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author weizhong
 * @date 2020/3/25 10:07 PM
 * @package com.nick.security.interceptor
 * @description
 */
@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("Time Interceptor PreHandle");
        log.info("Bean Name:{}", ((HandlerMethod)o).getBean().getClass().getName());
        log.info("Method Name:{}", ((HandlerMethod)o).getMethod().getName());
        httpServletRequest.setAttribute("stime", System.currentTimeMillis());
//        return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        long stime = (long) httpServletRequest.getAttribute("stime");
        log.info("Time Interceptor postHandle, costTime:{}", (System.currentTimeMillis() - stime));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long stime = (long) httpServletRequest.getAttribute("stime");
        log.info("Time Interceptor afterCompletion, costTime:{}", (System.currentTimeMillis() - stime));
    }
}
