package com.atguigu.dao;

import com.atguigu.pojo.User;
import com.atguigu.utils.BaseDao;

/**
 * @author oono
 * @date 2020 10 15
 */
public class UserDaoImpl extends BaseDao implements UserDao{

    @Override
    public int saveUser(User user) {
        int updatedRows = update("INSERT INTO t_user(`username`,`password`,`email`) VALUES(?,?,?);", user.getUsername(), user.getPassword(), user.getEmail());
        return updatedRows;
    }

    @Override
    public User queryUserByUsername(String username) {
        User user = queryOne(User.class, "SELECT * FROM t_user WHERE username = ?", username);
        return user;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        User user = queryOne(User.class, "SELECT * FROM t_user WHERE username = ? AND PASSWORD = ?", username, password);
        return user;
    }
}
