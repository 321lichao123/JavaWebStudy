package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问Response1了");
        // 第一种重定向方式
        // response.setStatus(320);
        // response.setHeader("Location", "http://localhost:8080/07_servlet/response2");
        // 第二种重定向方式
        response.sendRedirect("http://localhost:8080/07_servlet/response2");
    }
}
