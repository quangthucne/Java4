package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("Role")) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
                if (cookie.getName().equals("UserId")) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
