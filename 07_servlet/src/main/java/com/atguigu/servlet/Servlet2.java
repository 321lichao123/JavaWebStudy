package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String username = request.getParameter("username");
        System.out.println("在servlet2中查看材料:" + username);
        // 设置域数据
        Object key = request.getAttribute("key");
        System.out.println("查看柜台1是否有章" + key);

        // c处理业务
        System.out.println("servlet2处理自己的业务");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
