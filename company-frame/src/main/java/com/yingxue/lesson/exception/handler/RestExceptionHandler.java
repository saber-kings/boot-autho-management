package com.yingxue.lesson.exception.handler;

import com.yingxue.lesson.exception.BusinessException;
import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.utils.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.cache.CacheException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;

/**
 * @author Saber污妖王
 * TODO: 公共异常处理类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/24
 * @package com.yingxue.lesson.exception.handler
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * 系统异常，请稍候再试
     *
     * @param e Exception
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(Exception.class)
    public DataResult<Object> handleException(Exception e) {
        log.error("Exception,{}", e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.SYSTEM_ERROR);
    }
    /**
     * 处理自定义业务异常
     *
     * @param e BusinessException
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(BusinessException.class)
    public DataResult<Object> businessException(BusinessException e) {
        log.error("Exception,{}", e.getLocalizedMessage());
        return DataResult.getResult(e.getCode(), e.getDefaultMessage());
    }

    /**
     * 处理validation 框架异常
     *
     * @param e MethodArgumentNotValidException
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DataResult<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("methodArgumentNotValidExceptionHandler bindingResult.allErrors():{},exception:{}",
                e.getBindingResult().getAllErrors(), e.getLocalizedMessage());
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        return createValidExceptionResp(errors);
    }

    private DataResult<Object> createValidExceptionResp(List<ObjectError> errors) {
        String[] msgs = new String[errors.size()];
        int i = 0;
        for (ObjectError error : errors) {
            msgs[i] = error.getDefaultMessage();
            log.info("msg={}", msgs[i]);
            i++;
        }
        return DataResult.getResult(BaseResponseCode.METHOD_IDENTITY_ERROR.getCode(), msgs[0]);
    }

    /**
     * 处理没有权限异常
     *
     * @param e UnauthorizedException
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(UnauthorizedException.class)
    public DataResult<Object> unauthorizedException(UnauthorizedException e) {
        log.error("UnauthorizedException,{}", e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.NOT_PERMISSION);
    }

    /**
     * 上传文件大小超出范围异常
     *
     * @param e MaxUploadSizeExceededException
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public DataResult<Object> maxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error("MaxUploadSizeExceededException, {}, {}", e, e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.UPLOAD_FILE_TOO_LARGE);
    }

    /**
     * 处理客户端突然断开连接异常
     *
     * @param e ClientAbortException
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(ClientAbortException.class)
    public DataResult<Object> clientAbortException(ClientAbortException e) {
        log.error("客户端突然断开连接,ClientAbortException,{}", e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.SYSTEM_ERROR);
    }

    /**
     * 处理缓存异常
     *
     * @param e Exception
     * @return com.yingxue.lesson.utils.DataResult
     */
    @ExceptionHandler(CacheException.class)
    public DataResult<Object> handleCacheException(CacheException e) {
        log.error("CacheException,{}", e.getLocalizedMessage());
        return DataResult.getResult(BaseResponseCode.SYSTEM_ERROR);
    }
}

