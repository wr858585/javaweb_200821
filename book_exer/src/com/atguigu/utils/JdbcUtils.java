package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author oono
 * @date 2020 10 15
 */
public class JdbcUtils {

    //先申明静态变量dataSource，好给方法中也使用
    static DataSource dataSource;

    //用静态代码块使当类加载的时候，static代码块就执行一次，让连接池得以配置好，准备就绪使用
    static{

        //创建属性类，准备之后装读取jdbc.properties中的配置信息
        Properties props = new Properties();

        //用类加载器反射读取jdbc.properties中存储的配置信息，并写入流中
        InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

        //用Properties类中的load()方法读取is流中的信息，并装入props容器
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //用德鲁伊连接池工厂类DruidDataSourceFactory中createDataSource()方法获取到连接池配置信息（通过传入props），创建连接池dataSource
        try {
            dataSource = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //还需要连个方法：获取连接getConnection，关闭连接closeConnection。因为其他的方法和功能德鲁伊连接池内部已经帮我们做好了

    /**
     * 获取连接
     * @return：返回一个连接；如果返回null，则获取连接失败
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接，放回连接池中
     * @param conn：需要释放的连接
     */
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
