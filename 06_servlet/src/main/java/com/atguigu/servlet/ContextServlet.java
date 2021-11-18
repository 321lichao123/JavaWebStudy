package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取xml中配置上下文的参数context-param
        ServletContext context = getServletContext();
        Enumeration<String> names = context.getInitParameterNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            System.out.println(element + " = " + context.getInitParameter(element));
        }

        // 2、获取工程路径
        System.out.println("工程路径" + context.getContextPath());

        // 3、获取工程部署后服务器硬盘的绝对路径
        // /斜杠被服务器解析的地址为：http://ip:port/工程名  映射到idea代码的web目录
        System.out.println("工程部署路径：" + context.getRealPath("/"));
        // 获取图片的路径
        System.out.println("获取webapp下面的图片绝对路径：" + context.getRealPath("/imgs/11.jpg"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
    }
}
