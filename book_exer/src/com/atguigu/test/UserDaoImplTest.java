package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 15
 */
public class UserDaoImplTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void saveUser() {
        userDao.saveUser(new User(null,"zqq123","zqq123","zqq123@qq.com"));
    }

    @Test
    public void queryUserByUsername() {
        User user = userDao.queryUserByUsername("zqq123");
//        System.out.println(user);
        //如果数据库中有这个username，则userDao中编写的queryUserByUsername()方法会返回User对象
        //如果不存在这个username，则查不到 --> 会返回null！（可以用sout语句试一下）
        if(user != null){
            System.out.println("用户名可用✔");
        } else{
            System.out.println("用户名已存在，不可使用");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("zqq123","zqq1213");
        if(user != null){
            System.out.println("登录成功");
        } else{
            System.out.println("用户名或密码输入错误，登录失败");
        }
    }
}