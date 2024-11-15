package com.example.scheduledevelop.service;


import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto create(String title, String contents) {

        // todo : 유저 email 값 가져오기

        User findUser = userRepository.findUserByIdOrElseThrow("");

        Schedule schedule = new Schedule(title, contents);

        schedule.setUser(findUser);

        Schedule saved = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saved.getId(), saved.getTitle(), saved.getContents(), saved.getUser().getUsername());
    }

    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

}
