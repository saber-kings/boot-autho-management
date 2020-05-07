package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Saber污妖王
 * TODO: 更新部门请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/5/1
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端更新部门请求提交的数据")
public class DeptUpdateReqVO {
    @ApiModelProperty(value = "部门id")
    @NotBlank(message = "部门id不能为空")
    private String id;

    @ApiModelProperty(value = "部门呢名称")
    private String name;

    @ApiModelProperty(value = "父级id")
    private String pid;

    @ApiModelProperty(value = "部门状态(1:正常；0:弃用)")
    private Integer status;

    @ApiModelProperty(value = "部门经理名称")
    private String managerName;

    @ApiModelProperty(value = "部门经理电话")
    private String phone;
}
