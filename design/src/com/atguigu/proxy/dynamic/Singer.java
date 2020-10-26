package com.atguigu.proxy.dynamic;

/**
 * @author oono
 * @date 2020 10 26
 */
public class Singer implements Star{
    @Override
    public String show(int money) {
        System.out.println("歌手表演了，得到了：" + money);
        return "演出成功";
    }
}
