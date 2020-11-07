package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author oono
 * @date 2020 10 26
 */
public class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"书1",new BigDecimal(10),1,new BigDecimal(10)));
        cart.addItem(new CartItem(1,"书1",new BigDecimal(10),1,new BigDecimal(10)));
        cart.addItem(new CartItem(2,"书2",new BigDecimal(30),3,new BigDecimal(90)));
        orderService.createOrder(1,cart);
    }

    @Test
    public void testReceiveOrder(){
        orderService.receiveOrder("1234567890");
    }

    @Test
    public void testOrderDetails(){
        System.out.println(orderService.orderDetails("1234567890"));
    }

    @Test
    public void testAllOrders(){
        orderService.allOrders().forEach(System.out::println);
    }

    @Test
    public void testSendOrder(){
        orderService.sendOrder("16036829543511");
    }
}