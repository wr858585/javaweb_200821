package com.atguigu.dao.impl;

import com.atguigu.pojo.OrderItem;
import com.atguigu.utils.BaseDao;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @author oono
 * @date 2020 10 24
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao{

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item values(?,?,?,?,?,?);";
        return update(sql,orderItem.getId(), orderItem.getName(), orderItem.getPrice(), orderItem.getCount(),
                orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
