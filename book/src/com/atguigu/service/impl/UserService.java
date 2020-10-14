package com.atguigu.service.impl;

import com.atguigu.pojo.User;

/**
 * @author oono
 * @date 2020 10 13
 */
public interface UserService {

    //注册用户
    public void registUser(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return：true-->用户名已存在，不可用；false-->用户名不存在，可以使用
     */
    public boolean existsUsername(String username);

    /**
     * 用户登录
     * @param user
     * @return：有返回值-->登录成功；返回null-->登录失败
     */
    public User login(User user);

}
