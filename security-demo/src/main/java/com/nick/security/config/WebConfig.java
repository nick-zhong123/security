package com.nick.security.config;

import com.nick.security.filter.TimeFilter;
import com.nick.security.interceptor.TimeInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author weizhong
 * @date 2020/3/25 9:29 PM
 * @package com.nick.security.config
 * @description
 *
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class WebConfig extends WebMvcConfigurerAdapter {

    private final TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean timeFilter () {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

}
