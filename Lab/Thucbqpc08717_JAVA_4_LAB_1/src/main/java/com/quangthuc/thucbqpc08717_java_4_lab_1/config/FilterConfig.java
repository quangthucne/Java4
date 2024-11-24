package com.quangthuc.thucbqpc08717_java_4_lab_1.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface FilterConfig extends Filter {  //config lại Filter interface

    // thuộc class Filter interface
    @Override
    default void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        this.doFilter(request, response, chain); // lối dệ quy vô hạn
    }

    void doFilter( HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException;

}
