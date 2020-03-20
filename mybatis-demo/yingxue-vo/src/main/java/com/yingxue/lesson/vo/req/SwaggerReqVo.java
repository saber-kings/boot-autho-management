package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/20
 * @Description:com.yingxue.lesson.vo.req
 * @version:1.0
 */
@Data
public class SwaggerReqVo {
    @ApiModelProperty(value = "账号")
    private String name;
    @ApiModelProperty(value = "密码")
    private String password;
}
