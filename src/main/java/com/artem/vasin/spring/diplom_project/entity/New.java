package com.artem.vasin.spring.diplom_project.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "news")
public class New {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "post_news")
    private String postNews;

    public New() {
    }

    public New(String title, String post_news) {
        this.title = title;
        this.postNews = post_news;
    }
}
