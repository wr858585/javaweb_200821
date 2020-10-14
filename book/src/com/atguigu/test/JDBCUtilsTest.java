package com.atguigu.test;

import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 13
 */
public class JDBCUtilsTest {

    @Test
    public void getConnection() {
        for (int i = 0; i < 100; i++) {
            Connection conn = JDBCUtils.getConnection();
            System.out.println(conn);
            JDBCUtils.closeConnection(conn);
        }
    }
}