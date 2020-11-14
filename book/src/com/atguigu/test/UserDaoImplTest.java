package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

/**
 * @author oono
 * @date 2020 10 13
 */
public class UserDaoImplTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        User admin1234 = userDao.queryUserByUsername("admin");
        if(admin1234 == null){
            System.out.println("用户名可用！");
        } else{
            System.out.println("用户名已存在，请另起一个吧");
        }
    }

    @Test
    public void saveUser() {
        userDao.saveUser(new User(null,"wzg168","666666","wzg168@qq.com"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("wzg168","666666") == null){
            System.out.println("用户名或密码输入错误，请重新输入");
        } else{
            System.out.println("登录成功");
        }
    }
}