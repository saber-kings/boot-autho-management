package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Saber污妖王
 * TODO: 用户数据分页查询的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/25
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端分页查询用户信息请求提交的数据")
public class UserPageReqVO {
    @ApiModelProperty("当前第几页")
    private Integer pageNum;

    @ApiModelProperty("当前页数量")
    private Integer pageSize;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("账户状态(1.正常 2.锁定 ")
    private Integer status;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    public UserPageReqVO() {
        this.pageNum = 1;
        this.pageSize = 10;
    }
}
