package com.quangthuc.demojpa;

import com.quangthuc.demojpa.bean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            signUp(req, resp, getValues(req));
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
        uniqueUser();
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    public UserBean getValues(HttpServletRequest req) throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = req.getParameterMap();
        UserBean userBean = new UserBean();
        BeanUtils.populate(userBean, map);
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
        }
        return userBean;
    }

    public void signUp(HttpServletRequest req, HttpServletResponse resp, UserBean userBean) throws ServletException, IOException {
//        for (Map.Entry<String, String[]> entry : getValues(req).entrySet()) {
//            String key = entry.getKey();
//            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
//            switch (key) {
//                case "name":
//                    user.setName(Arrays.toString(entry.getValue()));
//                    break;
//                case "username":
//                    user.setUsername(Arrays.toString(entry.getValue()));
//                    break;
//                case "password":
//                    user.setPassword(Arrays.toString(entry.getValue()));
//                    break;
//                case "email":
//                    user.setEmail(Arrays.toString(entry.getValue()));
//                    break;
//                case "address":
//                    user.setAddress(Arrays.toString(entry.getValue()));
//                    break;
//            }
//        }
        User user = new User();
        user.setUsername(userBean.getUsername());
        user.setPassword(userBean.getPassword());
        user.setEmail(userBean.getEmail());
        user.setAddress(userBean.getAddress());
        user.setName(userBean.getName());
        EntityHelper.insert(user);
    }
    public void uniqueUser() throws ServletException, IOException {
        EntityHelper.uniqueUsername("abc");
    }
}
