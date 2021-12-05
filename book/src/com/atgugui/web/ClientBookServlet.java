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

/**
 * ClassName: ClientBookServlet
 *
 * @Author: lichao
 * @Date: 2021/12/5
 * @Description:
 */
public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求参数page和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2、调用BookService.Page(pageNo, pageSize)
        Page<Book> page = bookService.page(pageNo, pageSize);
        // 设置url的地址
        page.setUrl("client/clientBookServlet?action=page");
        // 3、保存page对象到Request域中
        req.setAttribute("page", page);
        // 4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求参数page和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        // 2、调用BookService.Page(pageNo, pageSize)
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        // 设置url的地址
        page.setUrl(sb.toString());
        // 3、保存page对象到Request域中
        req.setAttribute("page", page);
        // 4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
