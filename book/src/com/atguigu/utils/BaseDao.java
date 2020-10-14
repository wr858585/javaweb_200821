package com.atguigu.utils;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author oono
 * @date 2020 10 13
 */
public abstract class BaseDao {

    /*
    QueryRunner是DBUtils包中提供的一个专门用来执行sql语句的工具类
    1. int update()用于执行insert,update,delete写操作的sql语句
    2. query()用于执行select查询操作
    查询值分为以下三种情况：（特殊的情况用map处理）
    1. 返回一个JavaBean对象
    2. 返回多个JavaBean对象
    3. 返回一行单列数据
    在DBUtils包中，有一个接口叫ResultSetHandler，它负责将查询过来的结果，转换为我们需要的数据
    1. 返回一个JavaBean对象 --> BeanHandler<T>(type)
    2. 返回多个JavaBean对象 --> BeanListHandler<T>(type)
    3. 返回一行单列的数据 --> ScalarHandler()
     */

    QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行返回一行单列数据的sql语句的方法 --> BeanHandler
     * @param sql： sql语句
     * @param args：sql占位符对应的参数值
     * @return
     */
    protected Object queryList(String sql, Object args){

        Connection conn = JDBCUtils.getConnection();
        System.out.println();

        try {
            return queryRunner.query(sql, new ScalarHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("当前执行sql语句[" + sql +"]，参数值是：" + Arrays.asList(args) + "，发生了错误",throwables);
        } finally{
            JDBCUtils.closeConnection(conn);
        }
    }

    /**
     * 执行返回多个JavaBean对象sql语句
     * @param type：返回的数据类型
     * @param sql：sql语句
     * @param args：sql占位符对应的参数值
     * @param <T>：泛型类型
     * @return
     */
    protected <T> List<T> queryList(Class<T> type, String sql, Object ...args){

        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("当前执行sql语句[" + sql +"]，参数值是：" + Arrays.asList(args) + "，发生了错误",throwables);
        } finally{
            JDBCUtils.closeConnection(conn);
        }
    }

    /**
     * 执行并返回一个JavaBean对象
     * @param type：返回的数据类型
     * @param sql：sql语句
     * @param args：占位符对应的参数值
     * @param <T>
     * @return
     */
    protected <T> T queryOne(Class<T> type, String sql, Object ...args){

        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("当前执行sql语句[" + sql +"]，参数值是：" + Arrays.asList(args) + "，发生了错误",throwables);
        } finally{
            JDBCUtils.closeConnection(conn);
        }
    }

    /**
     * 用于执行insert,delete,update写操作的语句
     * @param sql：要执行的sql语句
     * @param args：sql语句中对应的？占位符的参数值
     * @return
     */
    protected int update(String sql, Object ...args){

        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("当前执行sql语句[" + sql +"]，参数值是：" + Arrays.asList(args) + "，发生了错误",throwables);
        } finally {
            JDBCUtils.closeConnection(conn);
        }
    }

}
