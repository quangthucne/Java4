package com.quangthuc.demojpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // bao gồm getter, setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;

}
