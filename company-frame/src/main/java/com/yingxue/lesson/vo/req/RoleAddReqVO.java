package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 新增角色请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/19
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端新增角色请求提交的数据")
public class RoleAddReqVO {
    @ApiModelProperty("角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String name;

    @ApiModelProperty("角色描述")
    private String description;

    @ApiModelProperty("角色状态(1:正常0:弃用)")
    private Integer status;

    @ApiModelProperty("所拥有的权限id集合")
    private List<String> permissions;
}
