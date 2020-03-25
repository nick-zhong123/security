package com.nick.security.validator;

import com.nick.security.service.HelloService;
import com.nick.security.service.impl.HelloServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author weizhong
 * @date 2020/3/25 11:39 AM
 * @package com.nick.security.validator
 * @description
 */
@Slf4j
@RequiredArgsConstructor
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    private final HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {

        log.info("MyConstraintValidator Init");

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("Tom");
        System.out.println(o);

        return false;
    }
}
