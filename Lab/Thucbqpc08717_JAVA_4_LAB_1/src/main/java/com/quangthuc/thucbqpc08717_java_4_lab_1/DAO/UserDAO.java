package com.quangthuc.thucbqpc08717_java_4_lab_1.DAO;

import com.quangthuc.thucbqpc08717_java_4_lab_1.config.EntityConfig;
import jakarta.persistence.*;
import model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDAO {
    private static EntityManager em = EntityConfig.getEntityManager();

    public static List<User> findALl() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();
        users.sort(Comparator.comparing(user -> user.getUsername()));
        return users;
    }

    public static User findById(int id) {
        User user = em.find(User.class, id);
        System.out.println(user.getName());
        return user;
    }

    public static List<User> findByUsername(String searchInput) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username OR u.name LIKE :name", User.class);
        query.setParameter("username",  searchInput);
        query.setParameter("name", "%" + searchInput + "%");
        List<User> users = query.getResultList();
        return users;
    }

    public static boolean checkUnique(String username) {
        boolean unique;
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        List<User> users = query.getResultList();
        if (users.size() > 0) {
            unique = false;
        }
        else {
            unique = true;
        }
        return unique;
    }

    public static ArrayList create(User user) {
        String message = "";
        int status = 0;
        ArrayList list = new ArrayList<>();
        if (checkUnique(user.getUsername())) {
            try {
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                System.out.println("Thêm thành công!");
                message = "Thêm thành công";
                status = 1;
                list.add(message);
                list.add(status);
            } catch (Exception e) {
                message = "Thêm thất bại!";
                list.add(message);
                list.add(status);
                em.getTransaction().rollback();
            }
        } else {
            message = "Username đã tồn tại!";
            list.add(message);
            list.add(status);
        }

        return list;
    }


    public static ArrayList checkUpdate(User userUpdate) {
        String message = "";
        int status = 0;
        ArrayList list = new ArrayList<>();
        User user = em.find(User.class, userUpdate.getId());
        if (userUpdate.getUsername().equals(user.getUsername())) {
            user.setUsername(userUpdate.getUsername());
            user.setPassword(userUpdate.getPassword());
            user.setRole(userUpdate.getRole());
            user.setEmail(userUpdate.getEmail());
            try {
                em.getTransaction().begin();
                em.merge(user);
                em.getTransaction().commit();
                System.out.println("Chỉnh sửa thành công!");
                message = "Chỉnh sửa thành công";
                status = 1;
                list.add(message);
                list.add(status);
            } catch (Exception e) {
                message = "Chỉnh sửa thất bại!";
                list.add(message);
                list.add(status);
                em.getTransaction().rollback();
                e.printStackTrace();
            }

        }
        else {
            if (!checkUnique(userUpdate.getUsername())) {
                message = "Username đã tồn tại!";
                list.add(message);
                list.add(status);
            }
            else {
                user.setUsername(userUpdate.getUsername());
                user.setPassword(userUpdate.getPassword());
                user.setRole(userUpdate.getRole());
                user.setEmail(userUpdate.getEmail());
                try {
                    em.getTransaction().begin();
                    em.merge(user);
                    em.getTransaction().commit();
                    System.out.println("Chỉnh sửa thành công!");
                    message = "Chỉnh sửa thành công";
                    status = 1;
                    list.add(message);
                    list.add(status);
                } catch (Exception e) {
                    message = "Chỉnh sửa thất bại!";
                    list.add(message);
                    list.add(status);
                    em.getTransaction().rollback();
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static void delete(int id) {
        User user = em.find(User.class, id);
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            System.out.println("Xóa không thành công");
        }
    }

    public static void findByEmailRole() {
        TypedQuery<User> userByEmail = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email AND u.admin = :role", User.class);
        userByEmail.setParameter("email", "%@fpt.edu.vn");
        userByEmail.setParameter("role", false);
        List<User> users = userByEmail.getResultList();
    }

    public static void findFirstRs() {
        int pageSize = 5;
        int pageNumber = 2;
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        List<User> users = query.getResultList();
    }

}
