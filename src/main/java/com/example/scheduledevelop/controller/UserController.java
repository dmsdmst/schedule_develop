package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.JoinRequestDto;
import com.example.scheduledevelop.dto.JoinResponseDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<JoinResponseDto> join(@RequestBody JoinRequestDto joinRequestDto) {

        JoinResponseDto joinResponseDto =
                userService.join(
                        joinRequestDto.getUsername(),
                        joinRequestDto.getPassword(),
                        joinRequestDto.getEmail()
                );

        return new ResponseEntity<>(joinResponseDto, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable Long id) {

        UserResponseDto userResponseDto = userService.findUser(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}



