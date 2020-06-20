package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 赋予用户角色请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/29
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端赋予用户角色请求提交的数据")
public class UserOwnRoleReqVO {
    @ApiModelProperty("用户id")
    @NotBlank(message = "用户id不能为空")
    private String userId;

    @ApiModelProperty("赋予用户的角色id集合")
    private List<String> roleIds;
}
