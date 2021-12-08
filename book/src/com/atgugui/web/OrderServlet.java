package com.atgugui.web;

import com.atgugui.pojo.Cart;
import com.atgugui.pojo.User;
import com.atgugui.service.OrderService;
import com.atgugui.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、先获取cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 2、获取用户id
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
            return;
        }
        int id = user.getId();
        // 3、调用OrderService创建orderId
        String orderId = orderService.createOrderId(cart, id);
        // 4、将订单存入域对象
        req.getSession().setAttribute("orderId", orderId);
        // 5、重定向到订单页面
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
