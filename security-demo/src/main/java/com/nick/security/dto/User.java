package com.nick.security.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.nick.security.validator.MyConstraint;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView {}

    @ApiParam(value = "用户ID")
    @JsonView(UserSimpleView.class)
    private String id;

    @MyConstraint(message = "这是一个测试")
    @JsonView(UserSimpleView.class)
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "生日必须为过去的时间")
    private Date birthday;

}
