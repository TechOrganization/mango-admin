package com.louis.mango.admin.vo;

import lombok.Data;

/**
 * @ClassName LoginBean
 * @Description TODO
 * @Autgor huang
 * @Date 2020-04-06 13:27
 */
@Data
public class LoginBean {

    private String account;

    private String password;

    private String captcha;
}
