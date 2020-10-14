package com.atguigu.dao.impl;

import com.atguigu.pojo.User;
import com.atguigu.utils.BaseDao;

/**
 * @author oono
 * @date 2020 10 13
 */
public class UserDaoImpl extends BaseDao implements UserDao{

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryOne(User.class,sql,username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryOne(User.class,sql,username,password);
    }
}
