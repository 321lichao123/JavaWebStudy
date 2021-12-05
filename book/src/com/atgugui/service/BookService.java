package com.atgugui.service;

import com.atgugui.pojo.Book;
import com.atgugui.pojo.Page;

import java.util.List;

/**
 * ClassName: BookService1
 *
 * @Author: lichao
 * @Date: 2021/12/1
 * @Description:
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBook();

    public Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
