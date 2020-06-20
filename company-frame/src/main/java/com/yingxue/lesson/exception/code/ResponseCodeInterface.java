package com.yingxue.lesson.exception.code;

/**
 * @author Saber污妖王
 * TODO: 封装统一的相应 code 的接口
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/24
 * @package com.yingxue.lesson.exception.code
 */
public interface ResponseCodeInterface {
    /**
     * 得到响应码
     *
     * @return 响应码
     */
    int getCode();

    /**
     * 得到响应信息
     *
     * @return 响应信息
     */
    String getMsg();
}
