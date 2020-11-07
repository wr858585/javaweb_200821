package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 24
 */
public interface OrderDao{

    public int saveOrder(Order order);

    public List<Order> queryOrdersByUserId(Integer userId);

    public void changeOrderStatus(String orderId, Integer Status);

    public List<Order> queryAllOrders();


}
