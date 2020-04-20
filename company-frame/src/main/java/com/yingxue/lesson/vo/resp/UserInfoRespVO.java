package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Saber污妖王
 * TODO: 用户信息的VO
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/27
 * @Package: com.yingxue.lesson.vo.resp
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "用户信息的封装类")
public class UserInfoRespVO {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("部门id")
    private String deptId;
    @ApiModelProperty("所属部门名称")
    private String deptName;
}
