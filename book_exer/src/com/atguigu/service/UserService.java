package com.atguigu.service;

import com.atguigu.pojo.User;

/**UserService接口中规定了三个要实现的功能（这些不是和数据库有关所以不属于DAO层，而是跟业务有关所以放在Service层）
 * 1.registUser：注册用户
 * 2.existsUsername：检查用户名是否已存在
 * 3.login：用户登录
 * @author oono
 * @date 2020 10 15
 */
public interface UserService {

    public boolean existsUsername(String username);

    public void registUser(User user);

    public User login(User user);

}
