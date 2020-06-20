package com.yingxue.lesson.vo.resp;

import com.yingxue.lesson.entity.SysRole;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO 响应查询用户拥有的角色请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/29
 * @package com.yingxue.lesson.vo.resp
 */
@Data
@ApiModel(description = "返回用户拥有的角色 id 集合和全部的角色信息集合")
public class UserOwnRoleRespVO {
    @ApiModelProperty("拥有角色集合")
    private List<String> ownRoles;

    @ApiModelProperty("所有角色列表")
    private List<SysRole> allRole;
}
