package com.atguigu.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oono
 * @date 2020 10 15
 */
public abstract class BaseDao {

    //dao层是数据层，是对数据库的CRUD操作
    //BaseDao是抽取CRUD的通用方法，不同的资源类要实现自己业务逻辑的CRUD一部分操作，只用调用部分BaseDao的方法即可

    //DBUtils是第三方出的jdbc编程工具包，其中有一个类叫QueryRunner，专门用于执行sql语句
    //1.query()方法用于sql的查询语句处理
    //2.update()方法用于sql的增删改语句操作处理，返回值是int，代表sql语句影响的行数

    //DBUtils还有一个接口叫ResultSetHandler，专门用于处理query()方法返回的ResultSet类型的实例变量
    //实现类有三，分别处理不同的ResultSet情况
    //1.BeanHandler()将查询的结果转换为一个JavaBean返回
    //2.BeanListHandler()将查询的结果转换为多个JavaBean，并封装到list集合中返回
    //3.ScalarHandler()将查询的结果（是某列值的时候-->相当于一个属性）返回

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行sql的CUD[create,update,delete]操作insert,update,delete语句
     * @param sql：要执行的sql语句
     * @param args：占位符
     * @return：返回sql语句影响的行数；若返回-1，表示sql语句执行失败
     */
    public int update(String sql,Object ...args){
        //获取连接池中的一个连接
        Connection conn = JdbcUtils.getConnection();
        try {
            //用queryRunner中的update()方法，传入connection连接实例对象，sql语句，占位符args的值，来实现对应的CUD操作
            int updatedRows = queryRunner.update(conn,sql,args);
            return updatedRows;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            //用finally来关闭连接，放回连接池。否则每进行一次CRUD操作，获取了连接都不放回去，则连接池没有可用连接了！
            JdbcUtils.closeConnection(conn);
        }
        //如果queryRunner.update()失败，则不会执行到return updatedRows，会去finally里面关闭连接，所以这里返回-1表示获取操作失败
        return -1;
    }

    /**
     * 执行query操作，且只查找某一列的数据（一个属性值）
     * @param sql：要执行的sql语句
     * @param args：占位符
     * @return：返回一个Object类型的变量；若返回null，表示查询失败
     */
    public Object queryForSingleValue(String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            Object query = queryRunner.query(conn, sql, new ScalarHandler(), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    /**
     * 执行只返回一个Bean对象的select语句
     * @param type：传入的pojo类类名，即需要将查询结果query封装到的javaBean类容器中
     * @param sql：要执行的sql语句
     * @param args：占位符
     * @param <T>：pojo类类型
     * @return：返回一个Bean对象；如果返回null，则执行失败
     */
    public <T> T queryOne(Class<T> type, String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();
        try {
            T query = queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    /**
     * 执行返回多个Bean对象的select语句
     * @param type：传入的pojo类类名
     * @param sql：要执行的sql语句
     * @param args：占位符
     * @param <T>：pojo类类型
     * @return：返回多个Bean对象的List数组；若返回null，则执行失败
     */
    public <T> List<T> queryList(Class<T> type, String sql, Object ...args){
        Connection conn = JdbcUtils.getConnection();
        List<T> list = new ArrayList<>();
        try {
            List<T> query = queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

}
