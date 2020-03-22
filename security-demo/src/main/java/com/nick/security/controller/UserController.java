package com.nick.security.controller;

import com.nick.security.dto.User;
import com.nick.security.dto.UserQueryCodition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author weizhong
 * @date 2020/3/22 10:12 PM
 * @package com.nick.security.web.controller
 * @description
 *
 */
@Slf4j
@RestController
public class UserController {

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> query(UserQueryCodition condition) {

        log.info("Condition:{}", condition.toString());
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;

    }

}
