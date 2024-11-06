package com.quangthuc.thucbqpc08717_java_4_lab_1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
}
