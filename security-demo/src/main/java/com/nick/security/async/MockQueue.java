package com.nick.security.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author weizhong
 * @date 2020/3/26 8:51 PM
 * @package com.nick.security.async
 * @description
 */
@Slf4j
@Component
@Data
public class MockQueue {

    private String placeOrder;
    private String completeOrder;

    public void setPlaceOrder(String placeOrder) throws Exception {
        new Thread(() -> {
            log.info("接到下单请求，" + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                log.error("setPlaceOrder,", e);
            }
            this.completeOrder = placeOrder;
        }).start();
        this.placeOrder = placeOrder;
    }
}
