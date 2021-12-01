package com.atgugui.test;

import com.atgugui.pojo.Book;
import com.atgugui.service.BookService;
import com.atgugui.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * ClassName: BookServiceImplTest
 *
 * @Author: lichao
 * @Date: 2021/12/1
 * @Description:
 */
public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "女人都是水做的", "刘小芳", new BigDecimal(199), 10, 100, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "女人不坏男人不爱", "小泽玛丽", new BigDecimal(1999), 10000, 10, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBook() {
        for (Book book : bookService.queryBook()) {
            System.out.println(book);
        }

    }
}