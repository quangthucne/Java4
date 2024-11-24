package com.quangthuc.thucbqpc08717_java_4_lab_1.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter(filterName = "userFilter", urlPatterns = "/home", dispatcherTypes = {DispatcherType.REQUEST})
public class HomeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String role = null;
        String userId = null;
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Role")) {
                    role = cookie.getValue();
                    System.out.println("Role: " + role);
                } else if (cookie.getName().equals("UserId")) {
                    userId = cookie.getValue();
                    System.out.println("UserId: " + userId);
                }
            }
        }

        if (role == null) {
                resp.sendRedirect(req.getContextPath() + "/login");

        } else if (role.equals("0")) {
                resp.sendRedirect(req.getContextPath() + "/home");
        } else if (role.equals("1")) {
                resp.sendRedirect(req.getContextPath() + "/address?id=" + userId );
        } else {
            chain.doFilter(request, response);
        }
    }


    @Override
    public void destroy() {

    }
}
