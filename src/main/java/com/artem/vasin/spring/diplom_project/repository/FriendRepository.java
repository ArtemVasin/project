package com.artem.vasin.spring.diplom_project.repository;

import com.artem.vasin.spring.diplom_project.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    List<Friend> findAllByLastNameFriend(String word);


}
