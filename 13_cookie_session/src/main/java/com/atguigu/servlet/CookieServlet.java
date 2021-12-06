package com.atguigu.servlet;

import com.atguigu.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 1、创建cookie
        Cookie cookie = new Cookie("key1", "value1");
        // 2、通知客户端保存cookie
        resp.addCookie(cookie);
        // 1、创建cookie
        Cookie cookie2 = new Cookie("key2", "value2");
        // 2、通知客户端保存cookie
        resp.addCookie(cookie2);
        // 3、客户端显示cookie
        resp.getWriter().write("cookie已经保存");

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write("cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br>");
        }
        Cookie iwantCookie = CookieUtils.findCookie("key2", cookies);
        if(iwantCookie != null) {
            System.out.println(iwantCookie);
            resp.getWriter().write("已经获取到cookies");
        }
    }
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        // 方案一：
        // 1、创建一个要修改的同名cookie对象
        // 2、在构造器，同时赋予新的cookie对象
//        Cookie cookie = new Cookie("key1", "newValue1");
        // 3、通知客户端修改cookie对象
//        resp.addCookie(cookie);

        // 方案二：
        // 1、先获取cookie对象
        Cookie key2Cookie = CookieUtils.findCookie("key2", req.getCookies());
        // 2、通过setValue来设置新的cookie值
        if (key2Cookie != null) {
            key2Cookie.setValue("newValue2");
            // 3、通知客户端修改cookie对象
            resp.addCookie(key2Cookie);
        }

        resp.getWriter().write("已经修改key1的cookie的值");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultKey", "defaultValue");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if(cookie != null) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("cookie已经被删除了");
        }
    }

    protected void setCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经设置了一个小时的cookie失效时间");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("cookiePath", "cookiePath");
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建一个带有Path路径的Cookie");
    }
}
