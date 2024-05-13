package com.Kuba2412.school.model;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String birthday;
    private String pesel;
    private String gender;
}
