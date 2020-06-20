package com.yingxue.lesson.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO 响应查询部门树请求的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/4/21
 * @package com.yingxue.lesson.vo.resp
 */
@Data
@ApiModel(description = "返回部门树的相关数据")
public class DeptRespNodeVO {
    @ApiModelProperty("部门id")
    private String id;

    @ApiModelProperty("部门名称")
    private String title;

    @ApiModelProperty("是否展开，默认true")
    private Boolean spread;

    @ApiModelProperty("子集/叶子节点")
    private List<DeptRespNodeVO> children;

    public DeptRespNodeVO() {
        this.spread = true;
    }
}
