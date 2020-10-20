package com.atguigu.service.impl;

import com.atguigu.dao.impl.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

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

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        //1.准备好Page容器
        Page<Book> page = new Page();
        //2.获取剩余的Page要注入的属性：pageCount总记录数，pageTotal总页数，items当前页面图书查询结果
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageCount = bookDao.queryForPageCount();
        //求总页码
        Integer pageTotal = pageCount/page.getPageSize();
        if(pageCount % page.getPageSize() != 0){
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //begin可由公式：begin = (pageNo - 1) * pageSize求得
        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        //求当前页面的数据items
        List<Book> items = bookDao.queryforPageItems(begin, page.getPageSize());
        //最后设置items属性
        page.setItems(items);

        return page;
    }
}
