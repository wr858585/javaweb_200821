package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**测试是否可以获取到连接池中的连接
 * @author oono
 * @date 2020 10 15
 */
public class JdbcUtilsTest {

    @Test
    public void getConnection() {

        //一次最多只能获取10个连接
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
        }

    }

    @Test
    public void closeConnection() {

        //每次用完后放回调用
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.closeConnection(connection);
        }

    }
}