package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: TestServlet2
 *
 * @Author: lichao
 * @Date: 2021/11/17
 * @Description:
 */
public class TestServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 如果重写init方法需要重写调用父类的init方法，否则浏览器访问不到这个页面
        // 因为父类中init将config保存下来了
        super.init(config);
        System.out.println("重写init初始化方法");
    }

    /**
    * Description: 在get请求的时候调用<br/>
    * @author: 12468<br/>
    * @date: 2021/11/17 22:46<br/>
    * @param:<br/>
    * @return:
    */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet2的doGet方法");
        ServletConfig servletConfig = getServletConfig();
        System.out.println("TestServlet2程序的别名是：" + servletConfig.getServletName());
        System.out.println(servletConfig.getServletContext());
    }

    /**
    * Description: 在post请求的时候调用<br/>
    * @author: 12468<br/>
    * @date: 2021/11/17 22:46<br/>
    * @param:<br/>
    * @return:
    */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet2的doPost方法");
    }
}
