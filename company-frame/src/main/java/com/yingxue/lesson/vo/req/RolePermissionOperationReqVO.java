package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 角色权限关联的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/19
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "封装角色权限关联的数据")
public class RolePermissionOperationReqVO {
    @ApiModelProperty("角色id")
    private String roleId;

    @ApiModelProperty("菜单权限集合")
    private List<String> permissionIds;
}
