package com.artem.vasin.spring.diplom_project.repository;

import com.artem.vasin.spring.diplom_project.entity.New;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRepository extends JpaRepository<New, Integer> {


    List<New> findAllByPostNews(String word);
}
