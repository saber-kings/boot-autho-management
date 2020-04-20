package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 菜单权限表的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/30
 * @Package: com.yingxue.lesson.vo.resp
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "菜单权限表的数据封装类")
public class PermissionRespNodeVO {
    @ApiModelProperty("主键id")
    private String id;
    @ApiModelProperty("跳转地址")
    private String url;
    @ApiModelProperty("菜单权限名称")
    private String title;
    @ApiModelProperty("子集集合")
    private List<?> children;
    @ApiModelProperty("是否展开 默认不展开(false)")
    private boolean spread=true;
}
