package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 角色权限关联的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/19
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "封装角色权限关联的数据")
public class RolePermissionOperationReqVO {
    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("菜单权限集合")
    private List<String> permissionIds;
}
