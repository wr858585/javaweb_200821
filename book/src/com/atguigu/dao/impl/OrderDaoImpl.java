package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import com.atguigu.utils.BaseDao;

/**
 * @author oono
 * @date 2020 10 24
 */
public class OrderDaoImpl extends BaseDao implements OrderDao{

    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)\n" +
                "VALUES(?,?,?,?,?);";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}

