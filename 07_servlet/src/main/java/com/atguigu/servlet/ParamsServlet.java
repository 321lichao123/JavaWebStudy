package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

public class ParamsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        // getParameter(): 获取是基本类型
        // getParameterValues()： 获取是数组
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry entry: parameterMap.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value =" + Arrays.toString((Object[]) entry.getValue()));
//            System.out.println("key = " + entry.getKey() + ", value =" + String.valueOf(entry.getValue()));
//            System.out.println("key = " + entry.getKey() + ", value =" + Arrays.asList(entry.getValue()));
        }
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            System.out.println(element + " = " + Arrays.asList(request.getParameterValues(element)));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--------------------------");
        // 为了解决中文乱挖的问题,必须在获取参数之前调用才生效
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobbies));

    }
}
