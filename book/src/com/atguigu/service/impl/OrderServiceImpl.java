package com.atguigu.service.impl;

import com.atguigu.dao.*;
import com.atguigu.dao.impl.*;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author oono
 * @date 2020 10 26
 */
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    /**
     * 创建一个订单
     * @param userId
     * @param cart
     * @return：返回订单号orderId
     */
    @Override
    public String createOrder(Integer userId, Cart cart) {
        String orderId = System.currentTimeMillis() + "" + userId;
        //1.保存订单
        orderDao.saveOrder(new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId));
        //2.保存订单项
        //遍历购物车中的商品项，转为订单项
        Collection<CartItem> values = cart.getItems().values();
        for (CartItem value : values) {
            //将每一个商品想转换为订单项
            OrderItem orderItem = new OrderItem(null,value.getName(),value.getPrice(),value.getCount(),value.getTotalPrice(),orderId);
            //修改库存和数量
            Book book = bookDao.queryBookById(value.getId());//得到购买的商品信息
            book.setSales(book.getSales() + value.getCount());//修改销量
            book.setStock(book.getStock() - value.getCount());//修改库存
            bookDao.updateBook(book);
            //保存订单项
            orderItemDao.saveOrderItem(orderItem);
        }
        //3.清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> myOrders(Integer userId) {
        List<Order> orders = orderDao.queryOrdersByUserId(userId);
        return orders;
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 2);
    }

    @Override
    public List<OrderItem> orderDetails(String orderId) {
        return orderItemDao.queryOrderItemsOrderId(orderId);
    }

    @Override
    public List<Order> allOrders() {
        return orderDao.queryAllOrders();
    }

    @Override
    public void sendOrder(String orderId){
        orderDao.changeOrderStatus(orderId,1);
    }
}
