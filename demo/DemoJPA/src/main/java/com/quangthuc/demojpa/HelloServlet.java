package com.quangthuc.demojpa;

import java.io.*;
import java.util.List;

import jakarta.persistence.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        demo();
    }

    public void destroy() {
    }

    public void demo() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PolyOE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        List<User> users = query.getResultList();
        users.forEach(user -> System.out.println(user.getFullname()));
    }
}