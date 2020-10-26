package com.atguigu.proxy.non_dynamic;

/**
 * @author oono
 * @date 2020 10 26
 */
public class Singer implements Star{

    @Override
    public void show(int money) {
        System.out.println("歌星唱歌，收入：" + money);
    }
}
