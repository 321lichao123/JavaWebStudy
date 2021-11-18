package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        System.out.println("在contextServlet1存入之前获取key1的值：" + context.getAttribute("key1"));

        // 向context出入键值对
        context.setAttribute("key1", "value1");

        System.out.println("在contextServlet1存入之后获取key1的值：" + context.getAttribute("key1"));

    }

}
