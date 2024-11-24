package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.UserDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.bean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet ("/")
public class LoginPages extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Lgoin Pages");
        req.getRequestDispatcher("/views/jsp/LoginPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            login(req, resp);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("title", "Lgoin Pages");


    }

    public static User getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = req.getParameterMap();
        UserBean userBean = new UserBean();
        BeanUtils.populate(userBean, map);
        User user = new User();
        user.setPassword(userBean.getPassword());
        user.setUsername(userBean.getUsername());
        return user;
    }

    public static void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        User user = getUser(req, resp);
        User userCheck = UserDAO.findByUsernameLogin(user.getUsername());
        System.out.println(userCheck.getUsername() + " " + userCheck.getPassword());
        if (userCheck.getPassword().equals(user.getPassword()) ) {
            setCookie(req, resp, userCheck);
            System.out.println("Đăng nhập thành công!!!");
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    public static void setCookie(HttpServletRequest req, HttpServletResponse resp, User user) {
        Cookie userId = new Cookie("UserId", String.valueOf(user.getId()));
        Cookie role = new Cookie("Role", String.valueOf(user.getRole()));
        userId.setMaxAge(60*60*24);
        role.setMaxAge(60*60*24);

        resp.addCookie(userId);
        resp.addCookie(role);
    }
}
