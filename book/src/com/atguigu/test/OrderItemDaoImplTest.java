package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author oono
 * @date 2020 10 24
 */
public class OrderItemDaoImplTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null,"母猪产后护理",new BigDecimal(100),1,new BigDecimal(100),"1234567890"));
    }
}
