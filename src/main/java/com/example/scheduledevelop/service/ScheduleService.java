package com.example.scheduledevelop.service;


import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.dto.UpdateScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto create(String title, String contents) {

        // todo : 유저 email 값 가져오기

        User findUser = userRepository.findUserByIdOrElseThrow(1L);

        Schedule schedule = new Schedule(title, contents);

        schedule.setUser(findUser);

        Schedule saved = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saved.getId(), saved.getTitle(), saved.getContents(), saved.getUser().getUsername(), saved.getCreatedDate());
    }

    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findScheduleById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(scheduleId);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents(), schedule.getUser().getUsername(), schedule.getCreatedDate());
    }

    @Transactional
    public UpdateScheduleResponseDto update(Long id, String title, String contents) {

        Schedule findSchedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        findSchedule.updateSchedule(title, contents);


        return new UpdateScheduleResponseDto(findSchedule.getId(), findSchedule.getTitle(), findSchedule.getContents(), findSchedule.getUser().getUsername(), findSchedule.getUpdatedDate());
    }


    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow((scheduleId));

        scheduleRepository.delete(schedule);
    }


}
