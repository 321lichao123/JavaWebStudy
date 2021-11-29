package com.atgugui.web;

import com.atgugui.pojo.User;
import com.atgugui.service.UserService;
import com.atgugui.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取登陆的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 2、判断用户名和密码是否正确
        if (userService.login(new User(null, username, password, null)) != null) {
            // 4、登陆成功
            System.out.println("登陆成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            // 3、用户名或者密码不正确跳回登陆页面
            req.setAttribute("msg", "用户名或者密码不正确");
            req.setAttribute("username", username);
            System.out.println("用户名[" + username + "]或者密码[" + password + "]不正确");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }

    }
}
