package com.yingxue.lesson.controller;

import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.utils.DataResult;
import com.yingxue.lesson.vo.req.TestReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 测试模块相关接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/24
 * @package com.yingxue.lesson.controller
 */
@RestController
@Api(tags = "测试模块")
@RequestMapping("/test")
public class TestController {
    @GetMapping("/index")
    @ApiOperation(value = "Swagger 测试 index 接口")
    public String testResult() {
        return "Hello World！";
    }

    @GetMapping("/home")
    @ApiOperation(value = "测试统一返回格式的接口")
    public DataResult<Object> getHome() {
        DataResult<Object> result = DataResult.getResult(BaseResponseCode.SUCCESS);
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        result.setData(list);
        //测试公共异常处理类是否生效
//        int i = 1 / 0;
        return result;
    }

    @GetMapping("/business/error")
    @ApiOperation(value = "测试主动抛出业务异常接口")
    public DataResult<String> testBusinessError(@RequestParam String type) {
        if (!("1".equals(type) || "2".equals(type) || "3".equals(type))) {
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        return new DataResult<>(0, type);
    }

    @PostMapping("/valid/error")
    @ApiOperation(value = "测试 Validator 抛出业务异常接口")
    public DataResult<Object> testValid(@RequestBody @Valid TestReqVO vo) {
        return DataResult.success(vo);
    }

}
