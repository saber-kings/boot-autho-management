package com.yingxue.lesson.vo.req;

import lombok.Data;

/**
 * @Auther:luanzhaofei@outlook.com
 * @Date:2020/3/20
 * @Description:com.yingxue.lesson.vo.req
 * @version:1.0
 */
@Data
public class RegisterReqVO {
    private String username;
    private String password;
    private Integer sex;
    private String phone;
    private Integer createWhere;
    private String email;
    private String nickName;
}
