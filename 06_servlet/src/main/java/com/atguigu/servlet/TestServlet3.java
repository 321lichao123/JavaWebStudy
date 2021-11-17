package com.atguigu.servlet; /**
 * ClassName: ${NAME}
 *
 * @Author: lichao
 * @Date: 2021/11/17${time}
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TestServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestServlet3的doGet方法");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestServlet3的doPost方法");
    }
}
