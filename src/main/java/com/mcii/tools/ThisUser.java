package com.mcii.tools;

import com.mcii.entity.Account;



/**
 * 将User对象保存在线程中，使之可以在此线程中随意调取而不需要访问数据库获取
 */
public class ThisUser {
    private static ThreadLocal<Account> userThreadLocal = new ThreadLocal<>();

    public static Account get(){
        return userThreadLocal.get();
    }

    public static void set(Account account){
        userThreadLocal.set(account);
    }

    public static void remove(){
        userThreadLocal.remove();
    }
}
