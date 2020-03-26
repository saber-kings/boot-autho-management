package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Saber污妖王
 * TODO: 用户数据分页的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/25
 * @Package: com.yingxue.lesson.vo.req
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "用户数据分页的数据封装类")
public class UserPageReqVO {
    @ApiModelProperty(value = "当前第几页")
    private Integer pageNum = 1;
    @ApiModelProperty(value = "当前页数量")
    private Integer pageSize = 10;
}
