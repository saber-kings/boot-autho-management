package com.yingxue.lesson.utils;

/**
 * @Author: 小霍
 * TODO: 编码工具类
 * @UpdateUser: Saber污妖王
 * @Project: company-frame
 * @Date: 2020/3/24
 * @Package: com.yingxue.lesson.utils
 * @Version: 0.0.1
 */
public class CodeUtil {

    private static final String DEPT_TPYE = "YXD";
//    private static final String PERMISSION_TPYE = "YXP";

    /**
     * 右补位，左对齐
     *
     * @param len    目标字符串长度
     * @param oriStr 原字符串
     * @param alexin 补位字符，以 alexin 做为补位
     * @return 目标字符串
     */
    public static String padRight(String oriStr, int len, String alexin) {
        StringBuilder str = new StringBuilder();
        int strlen = oriStr.length();
        if (strlen < len) {
            str.append(String.valueOf(alexin).repeat(len - strlen));
        }
        str.append(oriStr);
        return str.toString();
    }

    /**
     * 获取机构编码 YXD0001
     *
     * @param oriStr 初始值
     * @param len    位数
     * @param alexin 不足 以什么补充
     * @return java.lang.String
     */
    public static String deptCode(String oriStr, int len, String alexin) {
        return DEPT_TPYE + padRight(oriStr, len, alexin);
    }

}
