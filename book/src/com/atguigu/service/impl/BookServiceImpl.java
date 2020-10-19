package com.atguigu.service.impl;

import com.atguigu.dao.impl.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 19
 */
public class BookServiceImpl implements BookService{

    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
