package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 响应查询部门树的数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/4/21
 * @Package: com.yingxue.lesson.vo.resp
 * @Version: 0.0.1
 */
@Data
@ApiModel(description = "返回部门树的数据")
public class DeptRespNodeVO {
    @ApiModelProperty("部门id")
    private String id;

    @ApiModelProperty("部门名称")
    private String title;

    @ApiModelProperty("是否展开，默认true")
    private boolean spread = true;

    @ApiModelProperty("子集/叶子节点")
    private List<?> children;
}
