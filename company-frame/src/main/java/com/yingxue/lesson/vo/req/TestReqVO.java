package com.yingxue.lesson.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 测试 Hibernate Validator 的数据封装类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/24
 * @package com.yingxue.lesson.vo.req
 */
@Data
@ApiModel(description = "测试 Hibernate Validator 的数据封装类")
public class TestReqVO {
    @ApiModelProperty("名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    @NotNull(message = "age 不能为空")
    @ApiModelProperty("年龄")
    private Integer age;

    @NotEmpty(message = "id 集合不能为空")
    @ApiModelProperty("id集合")
    private List<String> ids;
}
