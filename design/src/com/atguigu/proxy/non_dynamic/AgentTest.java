package com.atguigu.proxy.non_dynamic;

import org.junit.Test;

/**
 * @author oono
 * @date 2020 10 26
 */
public class AgentTest {

    @Test
    public void testShow(){

        Star singer = new Singer();
        Star dancer = new Dancer();
        SingerAgent singerAgent = new SingerAgent(singer);
        DancerAgent dancerAgent = new DancerAgent(dancer);

        singerAgent.show(150);//歌星唱歌，收入：150
        dancerAgent.show(150);//舞者出台薪酬最低门槛要到200，否则不出台表演

    }


}
