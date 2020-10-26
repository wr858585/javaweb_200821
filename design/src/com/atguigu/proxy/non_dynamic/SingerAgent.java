package com.atguigu.proxy.non_dynamic;

/**
 * @author oono
 * @date 2020 10 26
 */
public class SingerAgent implements Star{

    Star singer;

    public SingerAgent(Star singer){
        this.singer = singer;
    }

    @Override
    public void show(int money) {

        //增强功能
        if(money > 100){
            singer.show(money);
        } else{
            System.out.println("歌手出台薪酬最低门槛100，低于100不出台表演");
        }

    }
}
