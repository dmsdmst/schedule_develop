package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    default User findUserByIdOrElseThrow(String email) {
        return findByEmail(email).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));

    }

}