package com.artem.vasin.spring.diplom_project.repository;

import com.artem.vasin.spring.diplom_project.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByNamePosts(String word);
}
