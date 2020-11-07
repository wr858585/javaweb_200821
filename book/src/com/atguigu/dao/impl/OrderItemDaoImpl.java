package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;
import com.atguigu.utils.BaseDao;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 24
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO t_order_item values(?,?,?,?,?,?);";
        return update(sql,orderItem.getId(), orderItem.getName(), orderItem.getPrice(), orderItem.getCount(),
                orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsOrderId(String orderId) {
        String sql = "SELECT id,NAME,price,COUNT,total_price AS totalPrice,order_id AS orderId FROM t_order_item WHERE order_id = ?";
        return queryList(OrderItem.class,sql,orderId);
    }
}
