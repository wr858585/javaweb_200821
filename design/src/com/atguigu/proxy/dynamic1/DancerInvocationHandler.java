package com.atguigu.proxy.dynamic1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author oono
 * @date 2020 10 26
 */
public class DancerInvocationHandler implements InvocationHandler {

    Object target;

    public DancerInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int pay = (int)args[0];
        //代理的增强功能
        if(pay > 200){
            Object result = method.invoke(target, args);
            return result;
        } else{
            return "舞者至少要200块哦，不然演出无能";
        }
    }
}
