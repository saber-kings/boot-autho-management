package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Saber污妖王
 * TODO: 角色信息分页查询的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/19
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端分页查询角色信息请求提交的数据")
public class RolePageReqVO {
    @ApiModelProperty("第几页")
    private Integer pageNum;

    @ApiModelProperty("当前页的数量")
    private Integer pageSize;

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @ApiModelProperty("角色状态(1:正常0:弃用)")
    private Integer status;

    public RolePageReqVO() {
        this.pageNum = 1;
        this.pageSize = 10;
    }
}
