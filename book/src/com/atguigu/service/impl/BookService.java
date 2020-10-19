package com.atguigu.service.impl;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 19
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

}
