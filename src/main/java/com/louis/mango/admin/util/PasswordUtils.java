package com.louis.mango.admin.util;

import java.util.UUID;

/**
 * @ClassName PasswordUtils
 * @Description TODO
 * @Autgor huang
 * @Date 2020-04-06 13:46
 */
public class PasswordUtils {

    /**
     * 匹配密码
     *
     * @param salt    盐
     * @param rawPass 明文
     * @param encpass 密文
     * @return
     */
    public static boolean matches(String salt, String rawPass, String encpass) {
        return new PasswordEncoder(salt).matches(rawPass, encpass);
    }

    /**
     * 明文密码加密
     *
     * @param rawPass 明文
     * @param salt    盐
     * @return
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * 获取加密盐
     *
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
