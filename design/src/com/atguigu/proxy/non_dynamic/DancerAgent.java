package com.atguigu.proxy.non_dynamic;

/**
 * @author oono
 * @date 2020 10 26
 */
public class DancerAgent implements Star{

    Star dancer;

    public DancerAgent(Star dancer){
        this.dancer = dancer;
    }

    @Override
    public void show(int money) {

        //增强功能
        if(money > 200){
            dancer.show(money);
        } else{
            System.out.println("舞者出台薪酬最低门槛要到200，否则不出台表演");
        }

    }
}
