package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author oono
 * @date 2020 10 13
 */
public class JDBCUtils {

    static DruidDataSource dataSource;

    static{

        //创建工具类Properties，用于加载jdbc.properties属性信息
        Properties props = new Properties();

        //通过类加载器，读取jdbc.properties属性配置信息
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

        //解析流中的数据，获得属性信息
        try {
            props.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //关闭流操作
        try {
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //根据数据库连接信息，创建数据库连接池
        try {
            //!
            //这一大段都是在做一件事：创建数据库连接池
            //而之所以要写那么多，是因为德鲁伊连接池的创建方法createDataSource需要传入Properties或者Map类的实例（因为配置信息都是键值对）
            //所以创建一个Properties空壳，再通过反射把写好的jdbc.properties配置文件里面的信息变成流
            //再用properties的load()方法读取到空壳中，最后把这个properties实例传入到createDataSource创建指定参数的连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //从数据库连接池中获取连接的方法
    public static Connection getConnection(){

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("获取连接失败！");
        }

        return conn;
    }

    //关闭连接，把连接放回池中的方法
    public static void closeConnection(Connection conn){

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
