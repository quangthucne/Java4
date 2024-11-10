package com.quangthuc.demojpa.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBean {
    private int id;
    private String customerName;
    private String phoneNumber;
    private String address;
    private User user;
}
