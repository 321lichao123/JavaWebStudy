package com.atgugui.web;

import com.atgugui.pojo.User;
import com.atgugui.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: RegisterServlet
 *
 * @Author: lichao
 * @Date: 2021/11/22
 * @Description:
 */
public class RegisterServlet  extends HttpServlet {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        // 2、判断验证码是否正确 暂时将验证码写死abcde后面修改
        if ("abcde".equalsIgnoreCase(code)) {
            // 4、如果验证码正确，则判断用户名是否存在
            if(userService.existUsername(username)) {
                // 5、如果用户名已存在，跳回注册页面
                System.out.println("用户名[" + username +"]已存在");
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
            } else {
                // 6、如果用户名不存在，保存用户到数据库中
                userService.registerUser(new User( username, password, email));
                // 跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        } else {
            // 3、如果不正确跳回注册页面
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
