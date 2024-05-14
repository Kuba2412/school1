package com.Kuba2412.school.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Teacher {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String birthday;
    private String pesel;
    private String gender;
    private BigDecimal salary;
}
