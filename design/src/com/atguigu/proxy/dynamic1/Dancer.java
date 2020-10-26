package com.atguigu.proxy.dynamic1;

/**
 * @author oono
 * @date 2020 10 26
 */
public class Dancer implements Star{

    @Override
    public String show(int pay) {
        System.out.println("舞者跳舞，得到：" + pay + "元");
        return "演出成功";
    }
}
