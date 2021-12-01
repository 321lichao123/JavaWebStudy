package com.atgugui.web;

import com.atgugui.dao.BookDao;
import com.atgugui.pojo.Book;
import com.atgugui.service.BookService;
import com.atgugui.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: BookServlet
 *
 * @Author: lichao
 * @Date: 2021/12/1
 * @Description:
 */
public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、通过BookService获取全部数据
        List<Book> books = bookService.queryBook();
        // 2、将数据存入Request域对象中
        req.setAttribute("books", books);
        // 3、请求转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
