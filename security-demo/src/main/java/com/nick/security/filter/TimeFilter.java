package com.nick.security.filter;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import java.io.IOException;

/**
 * @author weizhong
 * @date 2020/3/25 9:03 PM
 * @package com.nick.security.filter
 * @description
 */
@Slf4j
//@Component
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Time Filter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("TimeFilter DoFilter Start");
        long t1 = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("TimeFilter DoFilter CostTime:{}", System.currentTimeMillis() - t1);
        log.info("TimeFilter DoFilter End");
    }

    @Override
    public void destroy() {
        log.info("Time Filter Destroy");
    }
}
