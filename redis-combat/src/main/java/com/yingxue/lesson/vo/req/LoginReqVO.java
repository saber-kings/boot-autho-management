package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/20
 * @Description:com.yingxue.lesson.vo.req
 * @version:1.0
 */
@Data
@ApiModel(value = "com.yingxue.lesson.vo.req.LoginReqVO",description = "接收登陆用户数据的VO")
public class LoginReqVO {
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}
