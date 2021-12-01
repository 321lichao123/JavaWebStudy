package com.atgugui.service.impl;

import com.atgugui.dao.BookDao;
import com.atgugui.dao.impl.BookDaoImpl;
import com.atgugui.pojo.Book;
import com.atgugui.service.BookService;

import java.math.BigDecimal;
import java.util.List;

/**
 * ClassName: BookServiceImpl
 *
 * @Author: lichao
 * @Date: 2021/12/1
 * @Description:
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        int i = bookDao.addBook(book);
        if (i > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Override
    public void deleteBookById(Integer id) {
        int i = bookDao.deleteBookById(id);
        if (i > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void updateBook(Book book) {
        int i = bookDao.updateBook(book);
        if (i > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBook() {
        return bookDao.queryBooks();
    }
}
