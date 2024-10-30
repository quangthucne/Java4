package com.quangthuc.thucbqpc08717_java_4_lab_1.manage;

import jakarta.persistence.*;
import model.User;

import java.util.List;

public class UserManager {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
    private EntityManager em = emf.createEntityManager();

    public void findALl() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();
        users.forEach(user -> {
           String fullname = user.getFullname();
           boolean admin = user.getAdmin();
            System.out.println(fullname + " : " + admin);
        });
    }

    public void findById(String id) {
        User user = em.find(User.class, id);
        String fullname = user.getFullname();
        boolean admin = user.getAdmin();
        System.out.println(fullname + " : " + admin);
    }

    public void create() {
        User newUser = new User("U16", "123", "teo@gmail.com", "Tèo", false);
        try {
            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();
            System.out.println("Thêm thành công!");
        } catch (Exception e) {
            System.out.println("Thêm không thành công");
        }
    }

    public void update() {
        User user = em.find(User.class, "U16");
        user.setFullname("Nguyễn Văn Tèo");
        user.setEmail("teonv@gmail.com");
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            System.out.println("Chỉnh sửa thành công!");
        } catch (Exception e) {
            System.out.println("Chỉnh sửa không thành công");
        }
    }

    public void delete() {
        User user = em.find(User.class, "U16");
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
            System.out.println("Xóa thành công");
        } catch (Exception e) {
            System.out.println("Xóa không thành công");
        }
    }

    public void findByEmailRole() {
        TypedQuery<User> userByEmail = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :email AND u.admin = :role", User.class);
        userByEmail.setParameter("email", "%@fpt.edu.vn");
        userByEmail.setParameter("role", false);
        List<User> users = userByEmail.getResultList();
        users.forEach(user -> {
            String fullname = user.getFullname();
            String email = user.getEmail();
            System.out.println(fullname + " : " + email);
        });
    }

    public void findFirstRs() {
        int pageSize = 5;
        int pageNumber = 2;
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        List<User> users = query.getResultList();
        users.forEach(user -> {
            String fullname = user.getFullname();
            String email = user.getEmail();
            System.out.println(fullname + " : " + email);
        });
    }

}
