package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.AddressDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/address")
public class AddressHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("addressList", getAddresses(req));
        req.setAttribute("userId", req.getParameter("id"));
        req.getRequestDispatcher("/views/jsp/AddressHome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        search(req, resp);
        req.getRequestDispatcher("/views/jsp/AddressHome.jsp").forward(req, resp);

    }

    public List<Address> getAddresses(HttpServletRequest req) {
        int userId = Integer.parseInt(req.getParameter("id"));
        List<Address> addressList = AddressDAO.findByUser(userId);
        return addressList;
    }

    public static void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchInput = req.getParameter("search");
        List<Address> addresses = null;
        if (searchInput != null) {
            addresses = AddressDAO.findByName(searchInput);
            req.setAttribute("addressList", addresses);
        } else {
            req.setAttribute("addressList", AddressDAO.findAll());
        }
    }

}
