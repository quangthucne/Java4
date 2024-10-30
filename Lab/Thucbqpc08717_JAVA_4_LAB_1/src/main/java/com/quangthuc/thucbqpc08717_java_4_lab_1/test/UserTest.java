package com.quangthuc.thucbqpc08717_java_4_lab_1.test;

import com.quangthuc.thucbqpc08717_java_4_lab_1.manage.UserManager;

public class UserTest {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.findALl();
        System.out.println("====================================================");
        userManager.findById("U01");
        System.out.println("====================================================");
        userManager.create();
        System.out.println("====================================================");
        userManager.findALl();
        System.out.println("====================================================");
        userManager.update();
        System.out.println("====================================================");
        userManager.findALl();
        System.out.println("====================================================");
        userManager.delete();
        System.out.println("====================================================");
        userManager.findALl();
        System.out.println("====================================================");
        userManager.findByEmailRole();
        System.out.println("===================================================");
        userManager.findFirstRs();
        System.out.println("===================================================");
    }
}
