package com.yingxue.lesson.vo.resp;

import com.yingxue.lesson.entity.SysRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 响应查询用户拥有的角色请求的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/29
 * @Package: com.yingxue.lesson.vo.resp
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "返回用户拥有的角色 id 集合和全部的角色信息集合")
public class UserOwnRoleRespVO {
    @ApiModelProperty("拥有角色集合")
    private List<String> ownRoles;

    @ApiModelProperty("所有角色列表")
    private List<SysRole> allRole;
}
