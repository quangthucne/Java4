package com.quangthuc.thucbqpc08717_java_4_lab_1.servlet;

import com.quangthuc.thucbqpc08717_java_4_lab_1.DAO.AddressDAO;
import com.quangthuc.thucbqpc08717_java_4_lab_1.bean.AddressBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
        req.getRequestDispatcher("/views/jsp/EditAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address address = null;
        try {
           address = editAddress(req, resp);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/");



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
    public static Address editAddress(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Address address = getAddressEdit(req, resp);
        AddressDAO.update(address);
        return address;
    }
}
