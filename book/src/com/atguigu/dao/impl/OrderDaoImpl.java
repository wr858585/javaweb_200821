package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;
import com.atguigu.utils.BaseDao;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 24
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    /**
     * 生成一个订单
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "INSERT INTO t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)\n" +
                "VALUES(?,?,?,?,?);";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    /**
     * 按username查询所有用户的订单
     * @param userId
     * @return：一个Order集合
     */
    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "SELECT order_id AS orderId,create_time AS createTime,price,status,user_id AS userId FROM t_order WHERE user_id = ?";

        return queryList(Order.class, sql, userId);
    }

    @Override
    public void changeOrderStatus(String orderId, Integer status) {
        String sql = "UPDATE t_order SET STATUS = ? WHERE order_id = ?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql = "SELECT order_id AS orderId, create_time AS createTime, price, STATUS, user_id AS userId FROM t_order";
        return queryList(Order.class, sql);
    }

}

