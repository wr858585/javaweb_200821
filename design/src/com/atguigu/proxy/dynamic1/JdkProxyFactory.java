package com.atguigu.proxy.dynamic1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author oono
 * @date 2020 10 26
 */
public class JdkProxyFactory {

//    static class InvacationHandler

    public static Object createProxy(Object target, InvocationHandler invocationHandler){
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
        , target.getClass().getInterfaces()
        , invocationHandler);
    }

}
