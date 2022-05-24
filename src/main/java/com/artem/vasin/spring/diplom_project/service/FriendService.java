package com.artem.vasin.spring.diplom_project.service;

import com.artem.vasin.spring.diplom_project.entity.Friend;
import com.artem.vasin.spring.diplom_project.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendRepository friendRepository;

    public List<Friend> findAllByLastNameFriend(String word) {
        List<Friend> list = friendRepository.findAllByLastNameFriend(word);
        return list;
    }
}
