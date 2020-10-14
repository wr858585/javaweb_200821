package com.atguigu.dao.impl;

import com.atguigu.pojo.User;

/**
 * @author oono
 * @date 2020 10 13
 */
public interface UserDao {

    //根据用户名查询用户
    public User queryUserByUsername(String username);

    //保存用户
    public int saveUser(User user);

    //根据用户名和密码查询用户
    public User queryUserByUsernameAndPassword(String username, String password);

}
