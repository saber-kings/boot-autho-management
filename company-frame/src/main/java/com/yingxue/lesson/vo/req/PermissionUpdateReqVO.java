package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Saber污妖王
 * TODO: 菜单权限更新请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/30
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端更新菜单权限请求提交的数据")
public class PermissionUpdateReqVO {
    @ApiModelProperty(value = "id")
    @NotBlank(message = "id 不能为空")
    private String id;

    @ApiModelProperty(value = "状态1:正常 0：禁用")
    private Integer status;

    @ApiModelProperty(value = "菜单权限名称")
    private String name;

    @ApiModelProperty(value = "菜单权限标识，shiro 适配restful")
    private String perms;

    @ApiModelProperty(value = "接口地址")
    private String url;

    @ApiModelProperty(value = "请求方式 和url 配合使用 (我们用 路径匹配的方式做权限管理的时候用到)")
    private String method;

    @ApiModelProperty(value = "父级id")
    private String pid;

    @ApiModelProperty(value = "排序码")
    private Integer orderNum;

    @ApiModelProperty(value = "菜单权限类型(1:目录;2:菜单;3:按钮)")
    private Integer type;

    @ApiModelProperty(value = "编码(前后端分离，前端对按钮显示隐藏控制 btn-permission-search 代表菜单权限管理的列表查询按钮)")
    private String code;
}
