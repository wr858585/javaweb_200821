package com.atguigu.test;

import com.atguigu.dao.impl.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 14
 */
public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"bjj","bjj123","bjj@qq.com"));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("bjj")){
            System.out.println("用户名已经被注册，请换个名字吧");
        } else{
            System.out.println("可以注册");
        }
    }

    @Test
    public void login() {
        if (userService.login(new User(null,"admin","admin",null)) == null){
            System.out.println("用户名或密码输入有误，登录失败");
        } else{
            System.out.println("登录成功");
        }
    }
}