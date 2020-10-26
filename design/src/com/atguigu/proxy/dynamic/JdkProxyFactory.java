package com.atguigu.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author oono
 * @date 2020 10 26
 */
public class JdkProxyFactory {

    //创建Proxy对象实例的方法
    public static Object createJdkProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader()
                , target.getClass().getInterfaces()
                , (proxy, method, args) -> {
                    System.out.println("代理方法被调用了" + method);
                    int money = (int) args[0];
                    //proxy的增强功能
                    if (money > 100) {
                        Object result = method.invoke(target, args);
                        return result;
                    } else {
                        return "歌手薪资不到100，不演出";
                    }
                });
    }

}
