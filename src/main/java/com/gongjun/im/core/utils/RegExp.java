package com.gongjun.im.core.utils;


import com.google.common.base.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    /**
     * 比较宽泛校验
     * 邮箱格式正则
     * 以字母数字开头，@前面部分包括-._在内的格式，且-._不能在结尾部分
     * 有且仅有一个@符号
     * 末尾部分@后面的部分，必须是xx.xx这种格式，且点号前后的字符为  数字和字符串
     */
    public static final String REGEXP_EMAIL = "^[\\w]+([\\.|\\-|\\_]{1}[\\w]{1,})*([\\w])*[@]{1}[\\w]{1,}([.]{1}[a-zA-Z]{2,3})$";


    public static final String REGEXP_READER_IMAGE_CONTENT_TYPE_READER = "(png|jpg|jpeg|gif|ico|tiff|fax|x\\-icon|x\\-jpe|pnetvue|vnd\\.rn\\-realpix|vnd\\.wap\\.wbmp){1}";
    /**
     * 整型数据格式 以数字开头，且以数字结尾 不包括小数点，包括正负数
     */
    public static final String REGEXP_INTEGER = "^[\\-]{0,1}[0-9]{1,}$";
    /**
     * 包括正负的数字，小数或者整数
     */
    public static final String REGEXP_NUMERIC = "[\\-]{0,1}[0-9]{1,}[.]{0,1}[0-9]{0,}$";

    /**
     * HTTP HTTPS URL格式判定，忽略字母大小写
     */
    public static final String REGEXP_HTTP_URL = "(?i)^(http[s]{0,1}://){1}.{1,}$";

    /**
     * 手机号码格式 - 中国内地
     */
    public static final String REGEXP_PHONE = "^1[3|4|5|7|8][0-9]{9}$";

    /**
     * 密码格式校验
     * 6 ~ 16位字母或者数字或者组合
     */
    public static final String REGEXP_PWD = "^[0-9a-zA-Z]{6,16}$";

    /**
     * 字母或者数字，且不能为空
     */
    public static final String REGEXP_LETTER_OR_DIGITS = "^[0-9a-zA-Z]{1,}$";

    /**
     * IP，且不能为空
     */
    public static final String REGEXP_IP = "^(?:(?:2[0-4][0-9]\\.)|(?:25[0-5]\\.)|(?:1[0-9][0-9]\\.)|(?:[1-9][0-9]\\.)|(?:[0-9]\\.)){3}(?:(?:2[0-5][0-5])|(?:25[0-5])|(?:1[0-9][0-9])|(?:[1-9][0-9])|(?:[0-9]))$";

    public static boolean match(String exp, String src) {
        return Pattern.compile(Strings.nullToEmpty(exp)).matcher(Strings.nullToEmpty(src)).matches();
    }

    public static boolean isEmail(String str) {
        return match(REGEXP_EMAIL, str);
    }

    /**
     * 查询字符串src 中所有满足 regexp 正则表达式的数据 number 最多匹配出几个
     *
     * @param src
     * @param regexp
     * @param number
     * @return
     */
    public static String fetch(String src, String regexp, int number) {
        String res = "";
        int count = 0;
        if (number == 0) return res;
        Matcher matcher = Pattern.compile(Strings.nullToEmpty(regexp)).matcher(Strings.nullToEmpty(src));
        while (matcher.find()) {
            count++;
            res += matcher.group();
            if (number < 0) continue;
            else if (count >= number) break;
            else continue;
        }
        return res;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(match("^.{0,}[\\\\|/]$", "/"));
        System.out.println(match("^[\\\\|/].{0,}$", "\\htt:///"));
        String China = "中国";
        System.out.println(match(".*(" + China + ").*", "我是中国人哈"));
        System.out.println("21312423423".substring(0, 3));
    }
}
