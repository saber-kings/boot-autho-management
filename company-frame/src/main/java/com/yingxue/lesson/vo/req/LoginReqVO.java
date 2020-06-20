package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Saber污妖王
 * TODO: 登陆请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/25
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端登陆请求提交的数据")
public class LoginReqVO {
    @ApiModelProperty("账号")
    @NotBlank(message = "账号不能为空")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty("登录类型(1.web 2.android 3.ios )")
    @NotBlank(message = "用户登录类型不能为空")
    private String type;
}
