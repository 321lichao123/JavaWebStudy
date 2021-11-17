package com.atguigu.servlet;

import javax.servlet.*;
import java.io.IOException;

public class TestServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
    * Description: service方法是专门用来处理请求和响应的方法
    * date: 2021/11/17 14:27
    * @author: lichao 
    * @since JDK 1.8
    */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello 被访问了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
