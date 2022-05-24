package com.artem.vasin.spring.diplom_project.service;

import com.artem.vasin.spring.diplom_project.entity.Message;
import com.artem.vasin.spring.diplom_project.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findAllByContent(String word) {
        List<Message> list = messageRepository.findAllByContent(word);
        return list;
    }
}
