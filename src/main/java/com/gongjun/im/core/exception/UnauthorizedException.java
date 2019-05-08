package com.gongjun.im.core.exception;

/**
 * @Description: 自定义手动阿抛出异常
 * @Author:GongJun
 * @Date:2019/1/22
 */
public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }

}
