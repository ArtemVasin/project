package com.artem.vasin.spring.diplom_project.service;

import com.artem.vasin.spring.diplom_project.entity.User;
import com.artem.vasin.spring.diplom_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUsers(User user) {

        return userRepository.save(user);
    }


    public User getUsers(int id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUsersForLogin(String login) {
        User user = null;
        Optional<User> optional = userRepository.findByLogin(login);
        if (optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }

    public List<User> findAllBySurname(String word) {
        List<User> list = userRepository.findAllBySurname(word);
        return list;
    }
}
