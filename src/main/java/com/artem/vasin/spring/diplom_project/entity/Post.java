package com.artem.vasin.spring.diplom_project.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_posts")
    private String namePosts;



    public Post() {
    }

    public Post(String namePost, String content) {
        this.namePosts = namePost;

    }

    @Override
    public String toString() {
        return "Post{" +
                ", namePost='" + namePosts + '\'' +
//                ", client=" + client +
                '}';
    }
}
