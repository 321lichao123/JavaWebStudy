package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("Filter的构造器AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter的构造器init()");
        // 1、获取Filter的名称 filter-name的值
        System.out.println("filter-name的值:" + filterConfig.getFilterName());
        // 2、获取web.xml中配置的init-param初始化的参数值
        System.out.println("初始化的username参数值:" + filterConfig.getInitParameter("username"));
        System.out.println("初始化的password参数值:" + filterConfig.getInitParameter("password"));
        // 3、获取ServletContext对象
        System.out.println("ServletContext对象:" + filterConfig.getServletContext());
    }

    /**
     * 主要是用来拦截请求的
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter的doFilter()方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            return;
        } else {
            // 让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter的destroy()方法");
    }
}
