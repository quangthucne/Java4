package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.UserDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.bean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/register")
public class RegisterPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/jsp/RegisterPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            try {
                addUser(req, resp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/views/jsp/RegisterPage.jsp").forward(req, resp);

    }

    public static User getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = req.getParameterMap();
        UserBean userBean = new UserBean();
        BeanUtils.populate(userBean, map);
        User user = new User();
        user.setName(userBean.getName());
        user.setPassword(userBean.getPassword());
        user.setEmail(userBean.getEmail());
        user.setUsername(userBean.getUsername());
        user.setRole(1);
        return user;
    }

    public static void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        User user = getUser(req, resp);
        req.setAttribute("message", UserDAO.create(user));
    }
}
