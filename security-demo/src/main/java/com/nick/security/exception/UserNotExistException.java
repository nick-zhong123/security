package com.nick.security.exception;

/**
 * @author weizhong
 * @date 2020/3/25 2:41 PM
 * @package com.nick.security.exception
 * @description
 */
public class UserNotExistException extends RuntimeException {


    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
