package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Saber污妖王
 * TODO 响应客户端登陆请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/25
 * @package com.yingxue.lesson.vo.resp
 */
@Data
@ApiModel(description = "返回登陆请求结果的相关数据")
public class LoginRespVO {
    @ApiModelProperty("正常的业务token")
    private String accessToken;

    @ApiModelProperty("刷新token")
    private String refreshToken;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户id")
    private String id;

    @ApiModelProperty("电话")
    private String phone;
}
