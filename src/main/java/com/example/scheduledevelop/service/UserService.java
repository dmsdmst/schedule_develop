package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.JoinResponseDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public JoinResponseDto join(String username, String password, String email) {

        User user = new User(username, password, email);

        User savedUser = userRepository.save(user);

        return new JoinResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }


    public UserResponseDto findUser(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        User finduser = optionalUser.get();

        return new UserResponseDto(finduser.getUsername(), finduser.getEmail());

    }
}