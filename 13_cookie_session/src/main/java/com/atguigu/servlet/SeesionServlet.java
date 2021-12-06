package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SeesionServlet extends BaseServlet {
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建和获取session会话对象
        HttpSession session = req.getSession();
        // 判断当前session回话是否是新创建的
        boolean isNew = session.isNew();
        String id = session.getId();
        resp.getWriter().write("得到的session，他的id是" + id + "<br>");

    }
}
