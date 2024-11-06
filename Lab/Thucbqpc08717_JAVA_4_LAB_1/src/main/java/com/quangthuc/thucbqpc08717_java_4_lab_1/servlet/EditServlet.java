package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.bean.UserBean;
import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.UserDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.config.EntityConfig;
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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityConfig.getEntityManager();
        getUserById(req, resp);
        req.getRequestDispatcher("/views/jsp/EditUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            updateUser(req, resp);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/views/jsp/EditUser.jsp").forward(req, resp);
    }

    public static void getUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("user", UserDAO.findById(id));
    }

    public static User getUserUpdate (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
            Map<String, String[]> map = req.getParameterMap();
            UserBean userBean = new UserBean();
            BeanUtils.populate(userBean, map);
            User user = new User();
            user.setName(userBean.getName());
            user.setPassword(userBean.getPassword());
            user.setEmail(userBean.getEmail());
            user.setAddress(userBean.getAddress());
            user.setUsername(userBean.getUsername());
            user.setId(userBean.getId());
            user.setRole(1);
            return user;
    }

    public static void updateUser (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        User user = getUserUpdate(req, resp);
        System.out.println("User Id: " + user.getId());
        req.setAttribute("user", user);
        req.setAttribute("message", UserDAO.checkUpdate(user));
    }
}
