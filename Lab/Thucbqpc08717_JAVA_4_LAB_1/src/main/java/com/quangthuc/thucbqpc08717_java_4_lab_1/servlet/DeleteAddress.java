package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.AddressDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/delete-address")
public class DeleteAddress extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AddressDAO.delete(id);
        resp.sendRedirect(req.getContextPath() + "/address?id=" + getUserId(req));

    }
    public static int getUserId(HttpServletRequest req) {
        String role = null;
        String userId = null;
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("UserId")) {
                    userId = cookie.getValue();
                    System.out.println("UserId: " + userId);
                }
            }
        }
        return Integer.parseInt(userId);
    }
}
