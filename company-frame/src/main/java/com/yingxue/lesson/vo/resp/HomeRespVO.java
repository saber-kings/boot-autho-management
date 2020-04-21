package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 首页菜单栏的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/27
 * @Package: com.yingxue.lesson.vo.resp
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "返回首页菜单栏的数据")
public class HomeRespVO {
    @ApiModelProperty("用户信息")
    private UserInfoRespVO userInfoVO;
    @ApiModelProperty("首页菜单导航数据")
    private List<PermissionRespNodeVO> menus;
}
