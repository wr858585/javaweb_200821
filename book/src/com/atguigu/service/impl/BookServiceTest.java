package com.atguigu.service.impl;

import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author oono
 * @date 2020 10 19
 */
public class BookServiceTest {

    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"庄熙历险记","三毛",new BigDecimal("11.3"),33,2,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"我要再改名字","oono",new BigDecimal("99.9"),12,12,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }

    @Test
    public void page(){
        System.out.println(bookService.page(2, 4));
    }
}