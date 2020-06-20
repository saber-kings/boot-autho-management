package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 新增角色请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/19
 * @package com.yingxue.lesson.vo.req
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
