package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.AddressDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.bean.AddressBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/edit-address")
public class EditAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("address", getAddress(req, resp));
        System.out.println("id user address: " + getUserId(req));
        req.setAttribute("userId", getUserId(req));
        req.getRequestDispatcher("/views/jsp/EditAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            editAddress(req, resp);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        req.getRequestDispatcher("/views/jsp/EditAddress.jsp").forward(req, resp);



    }
    public static Address getAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("idUser"));
        int addressId = Integer.parseInt(req.getParameter("idAddress"));
        return AddressDAO.findIdAddUser(addressId, userId);
    }

    public static Address getAddressEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = req.getParameterMap();
        AddressBean addressBean = new AddressBean();
        BeanUtils.populate(addressBean, map);
        Address address = new Address();
        address.setAddress(addressBean.getAddress());
        address.setCustomerName(addressBean.getCustomerName());
        address.setPhoneNumber(addressBean.getPhoneNumber());
        address.setId(addressBean.getAddressId());
        return address;
    }
    public static void editAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Address address = getAddressEdit(req, resp);
        req.setAttribute("message", AddressDAO.update(address));
        req.setAttribute("userId", getUserId(req));
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
