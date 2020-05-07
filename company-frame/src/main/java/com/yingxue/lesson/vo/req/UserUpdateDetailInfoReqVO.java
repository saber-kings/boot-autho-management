package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Saber污妖王
 * TODO: 更新用户基本资料请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/1
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端更新用户基本资料请求提交的数据")
public class UserUpdateDetailInfoReqVO {
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "性别(1.男 2.女)")
    private Integer sex;

    @ApiModelProperty(value = "真实名称")
    private String realName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "手机号")
    private String phone;
}
