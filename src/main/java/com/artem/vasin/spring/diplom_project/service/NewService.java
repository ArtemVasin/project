package com.artem.vasin.spring.diplom_project.service;

import com.artem.vasin.spring.diplom_project.entity.New;
import com.artem.vasin.spring.diplom_project.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService {

    @Autowired
    private NewRepository newRepository;

    public List<New> getAllNews() {
        return newRepository.findAll();
    }

    public List<New> findAllByPostNews(String word) {
        List<New> list = newRepository.findAllByPostNews(word);
        return list;
    }

}
