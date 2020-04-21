package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: Saber污妖王
 * TODO: 菜单权限添加请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/11
 * @Package: com.yingxue.lesson.vo.resp
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端提交的添加菜单权限的请求数据")
public class PermissionAddReqVO {
    @ApiModelProperty("菜单权限名称")
    @NotBlank(message = "菜单权限名称不能为空")
    private String name;

    @ApiModelProperty("菜单权限标识，shiro 适配restful")
    private String perms;

    @ApiModelProperty("接口地址")
    private String url;

    @ApiModelProperty("请求方式 和url 配合使用 (我们用 路径匹配的方式做权限管理的时候用到)")
    private String method;

    @ApiModelProperty("父级id")
    @NotNull(message = "所属菜单不能为空")
    private String pid;

    @ApiModelProperty("排序码")
    private Integer orderNum;

    @ApiModelProperty("菜单权限类型(1:目录;2:菜单;3:按钮)")
    @NotNull(message = "菜单权限类型不能为空")
    private Integer type;

    @ApiModelProperty("状态1:正常 0：禁用")
    private Integer status;

    @ApiModelProperty("编码(前后端分离 前段对按钮显示隐藏控制 btn-permission-search 代表 菜单权限管理的列表查询按钮)")
    private String code;
}
