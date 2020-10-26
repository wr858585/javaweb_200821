package com.atguigu.proxy.non_dynamic;

/**
 * @author oono
 * @date 2020 10 26
 */
public class Dancer implements Star{
    @Override
    public void show(int money) {
        System.out.println("舞者跳舞，收入：" + money);
    }
}
