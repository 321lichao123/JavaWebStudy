package com.atgugui.web;

import com.atgugui.pojo.User;
import com.atgugui.service.impl.UserServiceImpl;
import com.atgugui.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ClassName: UserServlet
 *
 * @Author: lichao
 * @Date: 2021/11/29
 * @Description:
 */
public class UserServlet extends BaseServlet {

    UserServiceImpl userService = new UserServiceImpl();

    /**
    * Description: 登录的业务处理逻辑<br/>
    * @author: 12468<br/>
    * @date: 2021/11/29 22:17<br/>
    * @param:<br/>
    * @return:
    */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取登陆的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        // 2、判断用户名和密码是否正确
        if (userService.login(user) != null) {
            // 4、登陆成功
            System.out.println("登陆成功");
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            // 3、用户名或者密码不正确跳回登陆页面
            req.setAttribute("msg", "用户名或者密码不正确");
            req.setAttribute("username", username);
            System.out.println("用户名[" + username + "]或者密码[" + password + "]不正确");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
    /**
    * Description: 注册的业务逻辑<br/>
    * @author: 12468<br/>
    * @date: 2021/11/29 22:17<br/>
    * @param:<br/>
    * @return:
    */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        // 2、判断验证码是否正确 暂时将验证码写死abcde后面修改
        if ("abcde".equalsIgnoreCase(code)) {
            // 4、如果验证码正确，则判断用户名是否存在
            if(userService.existUsername(username)) {
                // 5、如果用户名已存在，跳回注册页面
                req.setAttribute("msg", "用户名已经存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                System.out.println("用户名[" + username +"]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                // 6、如果用户名不存在，保存用户到数据库中
                userService.registerUser(user);
                // 跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        } else {
            req.setAttribute("msg", "验证码不正确");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            // 3、如果不正确跳回注册页面
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、销毁session中用户登陆的信息
        req.getSession().invalidate();
        // 2、重定向到首页
        resp.sendRedirect(req.getContextPath());
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
////        方法一
////        if ("login".equalsIgnoreCase(action)) {
////            login(req, resp);
////        } else if ("regist".equalsIgnoreCase(action)){
////            regist(req, resp);
////        }
////        方法二
//        try {
//            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            method.invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
