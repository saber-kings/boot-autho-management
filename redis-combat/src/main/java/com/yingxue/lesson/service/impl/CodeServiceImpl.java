package com.yingxue.lesson.service.impl;

import com.yingxue.lesson.constants.Constant;
import com.yingxue.lesson.service.CodeService;
import com.yingxue.lesson.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * @Auther:Saber污妖王
 * @Date:2020/3/22
 * @Description:com.yingxue.lesson.service.impl
 * @version:1.0
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    private RedisService redisService;

    @Override
    public String getOrderCode(String type) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String date = simpleDateFormat.format(System.currentTimeMillis());
        Long number = redisService.incrby(Constant.ORDER_CODE_KEY + date, 1);
        String pad = padRight(number.toString(), 7, "0");
        return date+type+pad;
    }

    /**
     * 右补位，左对齐
     *
     * @param oldStr 原字符串
     * @param len    目标字符串长度
     * @param alexin 补位字符
     * @return 目标字符串
     * 以alexin 做为补位
     */
    public String padRight(String oldStr, int len, String alexin) {
        String str = "";
        int strlen = oldStr.length();
        if (strlen < len) {
            for (int i = 0; i < len - strlen; i++) {
                str = str + alexin;
            }
        }
        str = str + oldStr;
        return str;
    }
}
