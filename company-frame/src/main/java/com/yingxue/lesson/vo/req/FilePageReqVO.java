package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Saber污妖王
 * TODO: 文件分页查询的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/6/12
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "接收前端分页查询文件请求提交的数据")
public class FilePageReqVO {
    @ApiModelProperty("当前第几页")
    private Integer pageNum;

    @ApiModelProperty("当前页数量")
    private Integer pageSize;

    public FilePageReqVO() {
        this.pageNum = 1;
        this.pageSize = 10;
    }
}
