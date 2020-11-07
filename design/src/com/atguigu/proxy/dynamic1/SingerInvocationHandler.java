package com.atguigu.proxy.dynamic1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author oono
 * @date 2020 10 26
 */
public class SingerInvocationHandler implements InvocationHandler {

    Object target;

    public SingerInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int pay = (int)args[0];
        //singer代理的增强功能
        if(pay > 100){
            Object result = method.invoke(target, args);
            return result;
        } else{
            return "出场费不够100，歌手不表演了哦";
        }
    }
}
