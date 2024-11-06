package com.quangthuc.demojpa;

import com.quangthuc.demojpa.bean.UserBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.User;

import java.util.List;

public class EntityHelper {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo_jpa");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();
        users.forEach(user -> {
            String fullname = user.getName();
            System.out.println(fullname + " : ");
        });
        return users;
    }

    public static User getById(Long id) {
        return new User();
    }

    public static void uniqueUsername(String username){
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        User user = query.getSingleResult();
        if (user == null) {
            System.out.println("User not found");
        }
        else {
            System.out.println("User found");
        }
    }

    public static void insert(User user) {

        try {
            entityManager.getTransaction().begin();
            // persist là hàm insert
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            System.out.println("Đăng kí thành công! " + user);
        } catch (Exception e) {
            System.out.println("Đăng kí thất bại!");
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
        entityManager.close();
    }
}
