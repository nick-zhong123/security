package com.nick.security.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weizhong
 * @date 2020/3/26 8:57 PM
 * @package com.nick.security.async
 * @description
 */
@Slf4j
@Data
@Component
public class DefferResultHolder {

    private Map<String, DeferredResult<String>> map = new HashMap<>();

}
