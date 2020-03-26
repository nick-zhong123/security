package com.nick.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author weizhong
 * @date 2020/3/22 10:37 PM
 * @package com.nick.security
 * @description
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan(value = {"com.nick"})
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

}
