package com.atguigu.dao;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 24
 */
public interface OrderItemDao {

    //保存订单项
    public int saveOrderItem(OrderItem orderItem);

    //根据订单号查询订单中的商品集合
    List<OrderItem> queryOrderItemsOrderId(String orderId);

}
