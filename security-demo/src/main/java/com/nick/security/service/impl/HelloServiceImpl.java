package com.nick.security.service.impl;

import com.nick.security.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author weizhong
 * @date 2020/3/25 11:35 AM
 * @package com.nick.security.service.impl
 * @description
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String msg) {
        log.info("msg:{}", msg);
        return "hello:" + msg;
    }

}
