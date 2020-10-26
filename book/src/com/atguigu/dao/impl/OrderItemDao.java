package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

/**
 * @author oono
 * @date 2020 10 24
 */
public interface OrderItemDao {

    //保存订单项
    public int saveOrderItem(OrderItem orderItem);

}
