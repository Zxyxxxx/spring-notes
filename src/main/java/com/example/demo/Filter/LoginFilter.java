package com.example.demo.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义拦截器
 */
@WebFilter(urlPatterns = "/api/*", filterName = "loginFilter")//标记一个类为filter，被spring扫描 支持正则
public class LoginFilter implements Filter {

    /**
     * 初始化容器时加载
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }


    /**
     * 请求被拦截时调用
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter loginFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String username = request.getParameter("username");
        if ("xxx".equals(username)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            return;
        }

    }


    /**
     * 容器被销毁时调用
     */
    @Override
    public void destroy() {
        System.out.println("destroy loginFilter");
    }
}
