package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Saber污妖王
 * TODO: 角色信息分页的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/19
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "接收前端提交的角色信息分页的数据")
public class RolePageReqVO {
    @ApiModelProperty(value = "第几页")
    private int pageNum=1;
    @ApiModelProperty(value = "当前页的数量")
    private int pageSize=10;
}
