package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Saber污妖王
 * TODO 用户信息的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/27
 * @package com.yingxue.lesson.vo.resp
 */
@Data
@ApiModel(description = "封装首页菜单栏需要用到的用户信息")
public class UserInfoRespVO {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("部门id")
    private String deptId;

    @ApiModelProperty("所属部门名称")
    private String deptName;
}
