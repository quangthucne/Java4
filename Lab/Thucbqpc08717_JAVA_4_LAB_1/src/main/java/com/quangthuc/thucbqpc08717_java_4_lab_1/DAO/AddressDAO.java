package com.quangthuc.thucbqpc08717_java_4_lab_1.DAO;

import com.quangthuc.thucbqpc08717_java_4_lab_1.config.EntityConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Address;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddressDAO {
    private static EntityManager entityManager = EntityConfig.getEntityManager();

    public static List<Address> findAll() {
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a", Address.class);
        List<Address> addressList = query.getResultList();
        addressList.sort(Comparator.comparing(address -> address.getPhoneNumber()));
        return addressList;
    }

    public static Address findById(int id) {
        return entityManager.find(Address.class, id);
    }

    public static List<Address> findByName(String searchInput) {
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a WHERE a.customerName LIKE :customerName OR a.phoneNumber = :phoneNumber", Address.class);
        query.setParameter("customerName", "%" + searchInput + "%");
        query.setParameter("phoneNumber", searchInput);
        List<Address> addressList = query.getResultList();
        return addressList;
    }

    public static List<Address> findByUser(int id) {
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a WHERE a.user.id = :id", Address.class);
        query.setParameter("id", id);
        List<Address> addressList = query.getResultList();
        return addressList;
    }

    public static ArrayList create(Address address) {
        String message = "";
        int status = 0;
        ArrayList list = new ArrayList();
        System.out.println(address.getUser().getName());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            message = "Thêm địa chỉ thành công";
            status = 1;
        } catch (Exception e) {
            message = "Thêm thất bại!";
            list.add(message);
            list.add(status);
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        list.add(message);
        list.add(status);
        return list;
    }

    public static Address findIdAddUser(int addressId, int userId) {
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a WHERE a.user.id = :userId AND a.id = :addressId", Address.class);
        query.setParameter("userId", userId);
        query.setParameter("addressId", addressId);
        Address address = query.getSingleResult();
        return address;
    }

    public static Address update(Address address) {
        String message = "";
        int status = 0;
        ArrayList list = new ArrayList<>();
        Address addressById = entityManager.find(Address.class, address.getId());
        addressById.setAddress(address.getAddress());
        addressById.setCustomerName(address.getCustomerName());
        addressById.setPhoneNumber(address.getPhoneNumber());
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(addressById);
            entityManager.getTransaction().commit();
            message = "Chỉnh sửa thành công";
            status = 1;
            list.add(message);
            list.add(status);
        } catch (Exception e) {
            message = "Chỉnh sửa thất bại!";
            list.add(message);
            list.add(status);
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return address;
    }

    public static void delete(int id) {
        Address address = entityManager.find(Address.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(address);
        entityManager.getTransaction().commit();
    }
}
