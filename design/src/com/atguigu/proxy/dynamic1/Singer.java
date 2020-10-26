package com.atguigu.proxy.dynamic1;

/**
 * @author oono
 * @date 2020 10 26
 */
public class Singer implements Star{
    @Override
    public String show(int pay) {
        System.out.println("歌手唱歌，得到：" + pay + "元");
        return "演出成功";
    }
}
