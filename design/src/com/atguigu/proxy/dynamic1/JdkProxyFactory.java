package com.atguigu.proxy.dynamic1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author oono
 * @date 2020 10 26
 */
public class JdkProxyFactory {

    /**
     * 根据目标对象，创建出相应的代理实例对象
     * @param target
     * @param invocationHandler
     * @return
     */
    public static Object createProxy(Object target, InvocationHandler invocationHandler){
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
        , target.getClass().getInterfaces()
        , invocationHandler);
    }

}
