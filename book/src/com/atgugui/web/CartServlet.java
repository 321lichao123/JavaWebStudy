package com.atgugui.web;

import com.atgugui.dao.impl.BookDaoImpl;
import com.atgugui.pojo.Book;
import com.atgugui.pojo.Cart;
import com.atgugui.pojo.CartItem;
import com.atgugui.service.BookService;
import com.atgugui.service.impl.BookServiceImpl;
import com.atgugui.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * ClassName: CartServlet
 *
 * @Author: lichao
 * @Date: 2021/12/7
 * @Description:
 */
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求参数id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 2、通过BookService.queryBookById方法等到book
        Book book = bookService.queryBookById(id);
        // 3、通过Cart的addItem方法将商品添加到购物车梨
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice()));
        System.out.println(cart);
        // 4、重定向到购物列表中
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
