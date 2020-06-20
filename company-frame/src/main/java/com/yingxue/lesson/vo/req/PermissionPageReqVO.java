package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Saber污妖王
 * TODO: 用户数据分页查询的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/14
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端分页查询菜单权限信息请求提交的数据")
public class PermissionPageReqVO {
    @ApiModelProperty("当前第几页")
    private Integer pageNum;

    @ApiModelProperty("当前页数量")
    private Integer pageSize;

    @ApiModelProperty("菜权限名称")
    private String name;

    @ApiModelProperty("请求方式")
    private String method;

    @ApiModelProperty("菜单权限类型(1:目录;2:菜单;3:按钮)")
    private Integer type;

    @ApiModelProperty("状态1:正常 0：禁用")
    private Integer status;

    public PermissionPageReqVO() {
        this.pageNum = 1;
        this.pageSize = 10;
    }
}
