package com.yingxue.lesson.exception.code;

import lombok.AllArgsConstructor;

/**
 * @Author: Saber污妖王
 * TODO: 封装统一的相应 code 的枚举
 * @UpdateUser: luanz
 * @Project: company-frame
 * @Date: 2020/3/24
 * @Package: com.yingxue.lesson.exception.code
 * @Version: 0.0.1
 */
@AllArgsConstructor
public enum BaseResponseCode implements ResponseCodeInterface {
    /**
     * 这个要和前段约定好：
     * code=0：服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页。
     * code=4010001：（授权异常） 请求要求身份验证。 客户端需要跳转到登录页面重新登录。
     * code=4010002：(凭证过期) 客户端请求刷新凭证接口。
     * code=4030001：没有权限禁止访问。
     * code=400xxxx：系统主动抛出的业务异常。
     * code=5000001：系统异常。
     */
    SUCCESS(0, "操作成功"),
    SYSTEM_ERROR(5000001, "系统异常，请稍后再试"),
    DATA_ERROR(4000001, "传入数据异常"),
    METHOD_IDENTITY_ERROR(4000002, "数据校验异常"),
    ACCOUNT_ERROR(4000003, "该账号不存在"),
    ACCOUNT_LOCK(4010001, "该账号被锁定，请联系管理员"),
    ACCOUNT_PASSWORD_ERROR(4000004, "密码错误"),
    TOKEN_ERROR(4010001, "用户未登录，请重新登陆");

    /**
     * 响应码
     */
    private int code;

    /**
     * 提示
     */
    private String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
