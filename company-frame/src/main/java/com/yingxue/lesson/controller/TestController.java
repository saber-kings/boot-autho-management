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
 * @Author: Saber污妖王
 * TODO: 测试模块接口
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/24
 * @Package: com.yingxue.lesson.controller
 * @Version: 0.0.1
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
//        DataResult<String> result = DataResult.success();
        DataResult<Object> result = DataResult.getResult(BaseResponseCode.SUCCESS);
//        result.setData("哈哈哈哈！请求成功了！");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        result.setData(list);
        int i = 1 / 0;
        return result;
    }

    @GetMapping("/business/error")
    @ApiOperation(value = "测试主动抛出业务异常接口")
    public DataResult<String> testBusinessError(@RequestParam String type){
        if(!(type.equals("1")||type.equals("2")||type.equals("3"))){
            throw new BusinessException(BaseResponseCode.DATA_ERROR);
        }
        return new DataResult<>(0, type);
    }

    @PostMapping("/valid/error")
    @ApiOperation(value = "测试 Validator 抛出业务异常接口")
    public DataResult<Object> testValid(@RequestBody @Valid TestReqVO vo){
        return DataResult.success();
    }

}
