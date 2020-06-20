package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO 响应查询首页菜单栏请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/27
 * @package com.yingxue.lesson.vo.resp
 */
@Data
@ApiModel(description = "返回首页菜单栏的相关数据")
public class HomeRespVO {
    @ApiModelProperty("用户信息")
    private UserInfoRespVO userInfoVO;

    @ApiModelProperty("首页菜单导航数据")
    private List<PermissionRespNodeVO> menus;
}
