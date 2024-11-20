package com.quangthuc.thucbqpc08717_java_4_lab_1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBean {
    private int addressId;
    private String address;
    private String customerName;
    private String phoneNumber;
    private int userId;
}
