package com.atguigu.proxy.dynamic1;

/**
 * @author oono
 * @date 2020 10 26
 */
public class ProxyTest {

    public static void main(String[] args) {

        //目标对象
        Star singer = new Singer();
        Star dancer = new Dancer();

        //代理实例对象
        Star singerProxy = (Star) JdkProxyFactory.createProxy(singer, new SingerInvocationHandler(singer));
        Star dancerProxy = (Star) JdkProxyFactory.createProxy(dancer, new DancerInvocationHandler(dancer));

        //调用singerProxy的方法
        String result1 = singerProxy.show(150);
        System.out.println(result1);

        String result2 = dancerProxy.show(150);
        System.out.println(result2);

    }

}
