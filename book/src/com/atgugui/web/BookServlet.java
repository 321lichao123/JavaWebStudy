package com.atgugui.web;

import com.atgugui.pojo.Book;
import com.atgugui.pojo.Page;
import com.atgugui.service.BookService;
import com.atgugui.service.impl.BookServiceImpl;
import com.atgugui.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
        req.setCharacterEncoding("UTF-8");
        // 1、获取请求的参数
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        // 2、调用BookService.addBook()保存图书
        bookService.addBook(book);
        // 3、跳到图书列表页面 /manager/bookServlet?action=list
        // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=1&pageSize=2");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int parseInt = Integer.parseInt(id);
        bookService.deleteBookById(parseInt);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=1&pageSize=2");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=1&pageSize=2");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int parseInt = Integer.parseInt(id);
        Book book = bookService.queryBookById(parseInt);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?id=" + id).forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、通过BookService获取全部数据
        List<Book> books = bookService.queryBook();
        // 2、将数据存入Request域对象中
        req.setAttribute("books", books);
        // 3、请求转发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求参数page和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2、调用BookService.Page(pageNo, pageSize)
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        // 3、保存page对象到Request域中
        req.setAttribute("page", page);
        // 4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
