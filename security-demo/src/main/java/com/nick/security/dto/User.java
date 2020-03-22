package com.nick.security.dto;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author weizhong
 * @date 2020/3/22 9:37 PM
 * @package com.nick.security.dto
 * @description
 *
 */
@Data
public class User {

    private String id;

    private String username;

    private String password;

    private Date birthday;

}
