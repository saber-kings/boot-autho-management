package com.yingxue.lesson.exception.handler;

import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.utils.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Author: Saber污妖王
 * TODO: 公共异常处理类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/24
 * @Package: com.yingxue.lesson.exception.handler
 * @Version: 0.0.1
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    /**
     * 系统异常，请稍候再试
     *
     * @param e Exception
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(value = Exception.class)
    public DataResult handleException(Exception e) {
        log.error("Exception,{}", e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.SYSTEM_ERROR);
    }

    /**
     * 处理自定义业务异常
     *
     * @param e BusinessException
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(value = BusinessException.class)
    public DataResult businessException(BusinessException e) {
        log.error("Exception,{}", e.getLocalizedMessage());
        return DataResult.getResult(e.getCode(), e.getDefaultMessage());
    }

    /**
     * 处理validation 框架异常
     * @param e MethodArgumentNotValidException
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public DataResult methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("methodArgumentNotValidExceptionHandler bindingResult.allErrors():{},exception:{}",
                e.getBindingResult().getAllErrors(), e.getLocalizedMessage());
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return createValidExceptionResp(errors);
    }

    private DataResult createValidExceptionResp(List<ObjectError> errors) {
        String[] msgs = new String[errors.size()];
        int i = 0;
        for (ObjectError error : errors) {
            msgs[i] = error.getDefaultMessage();
            log.info("msg={}",msgs[i]);
            i++;
        }
        return DataResult.getResult(BaseResponseCode.METHOD_IDENTITY_ERROR.getCode(), msgs[0]);
    }
}
