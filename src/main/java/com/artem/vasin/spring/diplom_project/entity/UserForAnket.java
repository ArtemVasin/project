package com.artem.vasin.spring.diplom_project.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserForAnket {


    private String surname;
    private String name;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
    private List<Post> posts;

    public UserForAnket(String surname, String name, String dateOfBirth, String phoneNumber, String email) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public UserForAnket() {

    }
}
