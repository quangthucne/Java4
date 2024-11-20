package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.AddressDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.UserDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.bean.AddressBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import model.User;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet("/add-address")
public class AddAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userId", req.getParameter("userId"));
        req.getRequestDispatcher("/views/jsp/AddAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            try {
                addAddress(req, resp);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/views/jsp/AddAddress.jsp").forward(req, resp);
    }

    public static Address getAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = req.getParameterMap();
        AddressBean addressBean = new AddressBean();
        BeanUtils.populate(addressBean, map);
        Address address = new Address();
        address.setAddress(addressBean.getAddress());
        address.setCustomerName(addressBean.getCustomerName());
        address.setPhoneNumber(addressBean.getPhoneNumber());
        System.out.println("userId: " + addressBean.getUserId());
        User user = UserDAO.findById(addressBean.getUserId());
        address.setUser(user);
        return address;
    }
    public static void addAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Address address = getAddress(req, resp);
        req.setAttribute("message", AddressDAO.create(address));
    }
}
