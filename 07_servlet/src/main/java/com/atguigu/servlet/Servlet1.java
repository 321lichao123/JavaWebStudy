package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String username = request.getParameter("username");
        System.out.println("在servlet1中查看材料:" + username);
        // 设置域数据
        request.setAttribute("key", "柜台1的章");
        // 问路
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        // 走向servlet2
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
