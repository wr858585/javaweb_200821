package com.atguigu.dao;

import com.atguigu.pojo.User;

/**UserDao接口：要求User类需要具有三个功能（这些都是和数据库打交道的功能！）
 * 1.saveUser()保存用户操作
 * 2.queryUserByUsername()根据用户名查询用户操作
 * 3.queryUserByUsernameAndPassword()根据用户名和密码查询用户操作
 * @author oono
 * @date 2020 10 15
 */
public interface UserDao {

    //保存user对象到数据库
    public int saveUser(User user);

    //从数据库中根据用户名查询user对象
    public User queryUserByUsername(String username);

    //从数据库中根据用户名和密码查询user对象
    public User queryUserByUsernameAndPassword(String username, String password);

}
