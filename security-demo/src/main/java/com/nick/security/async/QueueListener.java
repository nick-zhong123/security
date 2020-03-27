package com.nick.security.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author weizhong
 * @date 2020/3/26 9:02 PM
 * @package com.nick.security.async
 * @description
 *
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private final MockQueue mockQueue;
    private final DefferResultHolder defferResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            while(true) {
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
                    String orderNumber = mockQueue.getCompleteOrder();
                    log.info("返回订单处理结果:{}", orderNumber);
                    defferResultHolder.getMap().get(orderNumber).setResult(orderNumber + ", place order success!");
                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        log.error("QueueListener onApplicationEvent", e);
                    }
                }
            }
        }).start();
    }

}
