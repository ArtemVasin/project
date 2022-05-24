package com.artem.vasin.spring.diplom_project.repository;

import com.artem.vasin.spring.diplom_project.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByContent(String word);
}
