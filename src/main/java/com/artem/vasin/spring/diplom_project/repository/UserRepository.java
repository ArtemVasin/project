package com.artem.vasin.spring.diplom_project.repository;

import com.artem.vasin.spring.diplom_project.entity.New;
import com.artem.vasin.spring.diplom_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    List<User> findAllBySurname(String word);

    Optional<User> findByLogin(String login);

}
