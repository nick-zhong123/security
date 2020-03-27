package com.nick.security.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author weizhong
 * @date 2020/3/26 9:30 PM
 * @package com.nick.security.async
 * @description
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AsyncController {

    private final MockQueue mockQueue;
    private final DefferResultHolder defferResultHolder;

    @RequestMapping("/order")
    public DeferredResult<String> order() throws Exception {
        log.info("主线程开始");

        String number = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(number);

        DeferredResult<String> result = new DeferredResult<>();
        defferResultHolder.getMap().put(number, result);
        log.info("主线程结束");
        return result;
    }
}
