package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 15
 */
public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void existsUsername() {
        if(userService.existsUsername("zqq1123")){
            System.out.println("用户名已存在，换一个吧");
        }else{
            System.out.println("用户名可用✔");
        }
    }

    @Test
    public void registUser() {
        userService.registUser(new User(null,"zqq1213","zqq123","zqq123@qq.com"));
    }

    @Test
    public void login() {
        if(userService.login(new User(null,"zqq1213","zqq123","zqq123@qq.com")) != null){
            System.out.println("登录成功");
        } else{
            System.out.println("登录失败");
        }
    }
}