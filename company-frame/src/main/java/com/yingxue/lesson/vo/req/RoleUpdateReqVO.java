package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 更新角色请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/30
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端更新角色请求提交的数据")
public class RoleUpdateReqVO {
    @ApiModelProperty(value = "角色id")
    @NotBlank(message = "角色 id 不能为空")
    private String id;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;

    @ApiModelProperty(value = "状态(1:正常0:弃用)")
    private Integer status;

    @ApiModelProperty(value = "所拥有的菜单权限")
    private List<String> permissions;
}
