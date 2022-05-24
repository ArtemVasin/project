package com.artem.vasin.spring.diplom_project.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "last_name_friend")
    private String lastNameFriend;

    @Column(name = "first_name_friend")
    private String firstNameFriend;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_friend")
    private List <Message> messages;

    public Friend() {
    }

    public Friend(String lastNameFriend, String firstNameFriend) {
        this.lastNameFriend = lastNameFriend;
        this.firstNameFriend = firstNameFriend;
    }
}
