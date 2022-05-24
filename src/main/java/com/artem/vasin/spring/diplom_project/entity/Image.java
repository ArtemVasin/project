package com.artem.vasin.spring.diplom_project.entity;

import lombok.Data;


import javax.persistence.*;


@Data
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "link")
    private String link;

    public Image() {
    }

    public Image(String link) {
        this.link = link;
    }
}
