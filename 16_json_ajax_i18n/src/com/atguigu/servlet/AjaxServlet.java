package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AjaxServlet
 * @Description
 * @Author 12468
 * @Date 2021/12/11 22:46
 * @Version 1.0
 */
public class AjaxServlet extends BaseServlet{

    private Gson gson = new Gson();

    public void javascriptToAjaxdoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajax请求");
        Person person = new Person(1, "李超");
        String toJson = gson.toJson(person);
        resp.getWriter().write(toJson);
    }
}
