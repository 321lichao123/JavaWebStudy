package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("前置代码1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("后置代码1");
    }

    @Override
    public void destroy() {

    }
}
