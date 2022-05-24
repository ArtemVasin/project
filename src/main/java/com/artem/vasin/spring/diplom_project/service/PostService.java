package com.artem.vasin.spring.diplom_project.service;

import com.artem.vasin.spring.diplom_project.entity.Post;
import com.artem.vasin.spring.diplom_project.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> findAllByNamePosts(String word) {
        List<Post> list = postRepository.findAllByNamePosts(word);
        return list;
    }
}
