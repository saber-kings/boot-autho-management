package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Saber污妖王
 * TODO: 更新用户请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/29
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端更新用户请求提交的数据")
public class UserUpdateReqVO {
    @ApiModelProperty("用户id")
    @NotBlank(message = "用户id不能为空")
    private String id;

    @ApiModelProperty("账号")
    @NotBlank(message = "账号不能为空")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty(value = "所属部门")
    @NotBlank(message = "所属部门不能为空")
    private String deptId;

    @ApiModelProperty(value = "账户状态(1.正常 2.锁定 )")
    private Integer status;
}
