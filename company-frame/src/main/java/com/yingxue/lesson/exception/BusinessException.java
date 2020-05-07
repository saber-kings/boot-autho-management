package com.yingxue.lesson.exception;

import com.yingxue.lesson.exception.code.ResponseCodeInterface;
import lombok.Getter;

/**
 * @Author: Saber污妖王
 * TODO: 自定义业务异常类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/24
 * @Package: com.yingxue.lesson.exception
 * @Version: 0.0.1
 */
@Getter
public class BusinessException extends RuntimeException {
    /**
     * 异常 code
     */
    private final int code;

    /**
     * 异常提示
     */
    private final String defaultMessage;

    public BusinessException(int code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    /**
     * 构造函数
     * @param code 异常码
     */
    public BusinessException(ResponseCodeInterface code) {
        this(code.getCode(), code.getMsg());
    }
}
