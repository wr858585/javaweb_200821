package com.atguigu.test;

import com.atguigu.dao.impl.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 19
 */
public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null,"从删库到跑路","国哥",new BigDecimal("9.9"),1000,1000,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22,"我要改名字","oono",new BigDecimal("99.9"),12,12,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(2));
    }

    @Test
    public void queryBooks() {
        bookDao.queryBooks().forEach(System.out::println);
    }
}