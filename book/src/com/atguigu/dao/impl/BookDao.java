package com.atguigu.dao.impl;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 19
 */
public interface BookDao {

    public int saveBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageCount();

    List<Book> queryForPageItems(Integer begin, Integer pageSize);

    int queryForPageCountByPrice(Integer min, Integer max);

    List<Book> queryForPageItemsByPrice(Integer begin, Integer size, Integer min, Integer max);

}
