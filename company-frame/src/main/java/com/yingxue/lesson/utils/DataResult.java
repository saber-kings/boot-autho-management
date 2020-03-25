package com.yingxue.lesson.utils;

import com.yingxue.lesson.exception.code.BaseResponseCode;
import com.yingxue.lesson.exception.code.ResponseCodeInterface;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @Author: Saber污妖王
 * TODO: 前后端分离统一数据封装类
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/24
 * @Package: com.yingxue.lesson.utils
 * @Version: 0.0.1
 */
@Data
@AllArgsConstructor
@ApiModel(description = "前后端分离规定统一的数据封装类")
public class DataResult<T> {
    /**
     * 请求响应code，0为成功，其他表示失败
     */
    @ApiModelProperty(value = "请求响应code，0为成功，其他表示失败", name = "code")
    private int code;
    /**
     * 响应客户端的提示
     */
    @ApiModelProperty(value = "响应/异常码的详细信息", name = "msg")
    private String msg;
    /**
     * 响应客户端的内容，code = 0 时返回数据
     */
    @ApiModelProperty(value = "需要返回的数据", name = "data")
    private T data;

    public DataResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public DataResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public DataResult() {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.data = null;
    }

    public DataResult(T data) {
        this.data = data;
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
    }

    public DataResult(ResponseCodeInterface responseCodeInterface) {
        this.data = null;
        this.code = responseCodeInterface.getCode();
        this.msg = responseCodeInterface.getMsg();
    }

    public DataResult(ResponseCodeInterface responseCodeInterface, T data) {
        this.data = data;
        this.code = responseCodeInterface.getCode();
        this.msg = responseCodeInterface.getMsg();
    }

    /**
     * 操作成功 data为null
     *
     * @return com.yingxue.lesson.utils.DataResult<T>
     * @Author: 小霍
     * @UpdateUser: Saber污妖王
     * @Version: 0.0.1
     */
    public static <T> DataResult success() {
        return new DataResult<T>();
    }

    /**
     * 操作成功 data 不为null
     *
     * @param data
     * @return com.yingxue.lesson.utils.DataResult<T>
     * @Author: 小霍
     * @UpdateUser: Saber污妖王
     * @Version: 0.0.1
     */
    public static <T> DataResult success(T data) {
        return new DataResult<T>(data);
    }

    /**
     * 自定义 返回操作 data 可控
     *
     * @param code
     * @param msg
     * @param data
     * @return com.yingxue.lesson.utils.DataResult<T>
     * @Author: 小霍
     * @UpdateUser: Saber污妖王
     * @Version: 0.0.1
     */
    public static <T> DataResult getResult(int code, String msg, T data) {
        return new DataResult<T>(code, msg, data);
    }

    /**
     * 自定义返回  data为null
     *
     * @param code
     * @param msg
     * @return com.yingxue.lesson.utils.DataResult<T>
     * @Author: 小霍
     * @UpdateUser: Saber污妖王
     * @Version: 0.0.1
     */
    public static <T> DataResult getResult(int code, String msg) {
        return new DataResult<T>(code, msg);
    }

    /**
     * 自定义返回 入参一般是异常code枚举 data为空
     *
     * @param responseCode
     * @return com.yingxue.lesson.utils.DataResult<T>
     * @Author: 小霍
     * @UpdateUser: Saber污妖王
     * @Version: 0.0.1
     */
    public static <T> DataResult getResult(BaseResponseCode responseCode) {
        return new DataResult<T>(responseCode);
    }

    /**
     * 自定义返回 入参一般是异常code枚举 data 可控
     *
     * @param responseCode
     * @param data
     * @return com.yingxue.lesson.utils.DataResult<T>
     * @Author: 小霍
     * @UpdateUser: Saber污妖王
     * @Version: 0.0.1
     */
    public static <T> DataResult getResult(BaseResponseCode responseCode, T data) {
        return new DataResult<T>(responseCode, data);
    }
}
