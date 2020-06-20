package com.yingxue.lesson.utils;

/**
 * @author 小霍
 * TODO: 编码工具类
 * @version 0.0.1
 * @editor Saber污妖王
 * @project company-frame
 * @date 2020/3/24
 * @package com.yingxue.lesson.utils
 */
public class CodeUtil {

    private static final String DEPT_TYPE = "YXD";
//    private static final String PERMISSION_TYPE = "YXP";

    /**
     * 右补位，左对齐
     *
     * @param len    目标字符串长度
     * @param oriStr 原字符串
     * @param fillIn 补位字符，以 fillIn 做为补位
     * @return 目标字符串
     */
    public static String padRight(String oriStr, int len, String fillIn) {
        StringBuilder str = new StringBuilder();
        int strLen = oriStr.length();
        if (strLen < len) {
            str.append(String.valueOf(fillIn).repeat(len - strLen));
        }
        str.append(oriStr);
        return str.toString();
    }

    /**
     * 获取机构编码 YXD0001
     *
     * @param oriStr 初始值
     * @param len    位数
     * @param fillIn 不足 以什么补充
     * @return java.lang.String
     */
    public static String deptCode(String oriStr, int len, String fillIn) {
        return DEPT_TYPE + padRight(oriStr, len, fillIn);
    }

}
