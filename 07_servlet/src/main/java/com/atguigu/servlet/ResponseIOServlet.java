package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    // 要求： 往客户端回传字符串数据

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决返回客户端中文乱码
        // 方法一：此方法必须在获取流之前使用
        // resp.setContentType("text/html;charset=UTF-8");
        // 方法二：
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("客户端返回的字符串1111");
    }
}
