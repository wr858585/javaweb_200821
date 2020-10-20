package com.atguigu.dao.impl;

import com.atguigu.pojo.Book;
import com.atguigu.utils.BaseDao;
import com.atguigu.utils.WebUtils;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 19
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int saveBook(Book book) {
        String sql = "insert into t_book values(null,?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        //这种sql语句一定要现在mysql中写出！！测试！！极易打错！！！！！！！！！！！！！！！！！！！！！！！！！！且发现不了！！！！！！！！！
//        String sql = "select `name`,`author`,`price`,`sales`,`stock`,img_path` imgPath,`id` from t_book where id = ?";
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath,`id` from t_book where id = ?";
        return queryOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path` as imgPath,`id` from t_book";
        return queryList(Book.class,sql);
    }

    @Override
    public Integer queryForPageCount() {
        String sql = "select count(*) from t_book";
        Object count = queryForSingleValue(sql);
        return WebUtils.parseInt(count.toString(),0);
    }

    @Override
    public List<Book> queryforPageItems(Integer begin, Integer pageSize) {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath,`id` from t_book limit ?,?";
        return queryList(Book.class,sql,begin,pageSize);
    }
}
