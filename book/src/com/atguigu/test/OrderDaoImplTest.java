package com.atguigu.test;

import com.atguigu.dao.impl.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 24
 */
public class OrderDaoImplTest {

    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(1000),0,1));
    }
}