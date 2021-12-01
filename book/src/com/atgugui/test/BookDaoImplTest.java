package com.atgugui.test;

import com.atgugui.dao.BookDao;
import com.atgugui.dao.impl.BookDaoImpl;
import com.atgugui.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName: BookDaoImplTest
 *
 * @Author: lichao
 * @Date: 2021/12/1
 * @Description:
 */
public class BookDaoImplTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "李超就是这么花", "李超", new BigDecimal(19999), 100000, 0, null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, "男人就是花心", "马云", new BigDecimal(19999), 100000, 0, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(20);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }

    }
}