package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 26
 */
public interface OrderService {

    public String createOrder(Integer id, Cart cart);

    public List<Order> myOrders(Integer userId);

    public void receiveOrder(String orderId);

    List<OrderItem> orderDetails(String orderId);

    List<Order> allOrders();

    void sendOrder(String orderId);

}
