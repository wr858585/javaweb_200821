package com.atguigu.proxy.dynamic;

import com.atguigu.proxy.non_dynamic.Dancer;

/**
 * @author oono
 * @date 2020 10 26
 */
public class ProxyTest {

    public static void main(String[] args) {

        Star singer = new Singer();
//        Star dancer = new Dancer();

        Star singerProxy = (Star)JdkProxyFactory.createJdkProxy(singer);

        String result = singerProxy.show(200);
        System.out.println(result);


    }

}
