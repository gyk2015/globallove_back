package com.mcii.tools.exception;



/**
 * 这是一个异常，用以切面检验用户是否已登录，没有则抛出此异常
 */
public class LoginException extends RuntimeException {

    public LoginException() {
        super("尚未登录!!!");
    }
}
