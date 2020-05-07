package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Saber污妖王
 * TODO: 修改密码请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/1
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端修改密码请求提交的数据")
public class UserUpdatePwdReqVO {
    @ApiModelProperty(value = "旧密码")
    @NotBlank(message = "旧密码不能为空")
    private String oldPwd;

    @ApiModelProperty(value = "新密码")
    @NotBlank(message = "新密码不能为空")
    private String newPwd;
}
