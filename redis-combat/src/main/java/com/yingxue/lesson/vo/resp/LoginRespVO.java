package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/21
 * @Description:com.yingxue.lesson.vo.resp
 * @version:1.0
 */
@Data
@ApiModel(value = "com.yingxue.lesson.vo.resp.LoginRespVO",description = "响应登陆用户数据的VO")
public class LoginRespVO {
    @ApiModelProperty(value = "用户认证凭证")
    private String token;
    @ApiModelProperty(value = "用户id")
    private String userId;

}
