package com.nick.security.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.nick.security.dto.User;
import com.nick.security.dto.UserQueryCodition;
import com.nick.security.exception.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
@RequestMapping("user")
public class UserController {

    @PostMapping
//    public User create(@Valid @RequestBody User user, BindingResult result) {
    public User create(@Valid @RequestBody User user) {

//        if (result.hasErrors()) {
//            result.getAllErrors().forEach(error -> log.info(error.getDefaultMessage()));
//        }
        log.info("id:{}, username:{}, password:{}, time:{}",
                user.getId(), user.getUsername(), user.getPassword(), user.getBirthday().getTime());
        return User.builder().id("1").build();
    }

    @DeleteMapping("{id:\\d+}")
    public String delete(@PathVariable String id) {
        log.info("delete id:{}", id);
        return "delete id:" + id;
    }

    @PutMapping("{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                log.info("Field:{}, message:{}", fieldError.getField(), error.getDefaultMessage());
            });
        }
        log.info("id:{}, username:{}, password:{}, time:{}",
                user.getId(), user.getUsername(), user.getPassword(), user.getBirthday().getTime());
        return User.builder().id("1").build();
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCodition condition) {
        log.info("Condition:{}", condition.toString());
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        return userList;
    }

    @GetMapping("{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {
        return User.builder().username("tom").build();
    }

    @GetMapping("/detail/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getDetailInfo(@PathVariable String id) {
        throw new UserNotExistException(id);
    }
}
