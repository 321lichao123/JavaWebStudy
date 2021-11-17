package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

public class TestServlet implements Servlet {

    public TestServlet() {
        System.out.println("1 构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 初始化");
        // 1、可以获取servlet程序的别名servlet-name的值
        System.out.println("TestServlet程序的别名是：" + servletConfig.getServletName());
        // 2、获取初始化参数init-param
        Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            System.out.println("TestServlet程序的参数" + servletConfig.getInitParameter(element));
        }
        // 3、获取servletContext对象
        System.out.println(servletConfig.getServletContext());
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
        System.out.println("3 service ==>>>>hello 被访问了");
        // 因为HttpServletRequest类下有getMethod()方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 获取方法请求的方式
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        if ("post".equalsIgnoreCase(method)) {
            doPost();
        } else if ("get".equalsIgnoreCase(method)) {
            doGet();
        }
    }

    public void doGet() {
        System.out.println("get请求");
    }

    public void doPost() {
        System.out.println("post请求");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println(" 4 destroy销毁方法");
    }
}
