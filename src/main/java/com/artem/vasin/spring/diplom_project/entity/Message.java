package com.artem.vasin.spring.diplom_project.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    private String content;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }
}
