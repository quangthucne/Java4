package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userList", getAllUser());
        req.getRequestDispatcher("/views/jsp/Home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        search(req, resp);
        req.getRequestDispatcher("/views/jsp/Home.jsp").forward(req, resp);

    }

    public static List<User> getAllUser() {
        List<User> users = UserDAO.findALl();
        return users;
    }

    public static void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchInput = req.getParameter("search");
        List<User> users = null;
        if (searchInput != null) {
            users = UserDAO.findByUsername(searchInput);
            req.setAttribute("userList", users);
        } else {
            req.setAttribute("userList", getAllUser());
        }
    }

}
