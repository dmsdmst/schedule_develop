package com.example.scheduledevelop.controller;


import com.example.scheduledevelop.dto.CreateScheduleRequestDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.dto.UpdateScheduleResponseDto;
import com.example.scheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;


    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> create(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.create(
                        requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }


    // 전체 일정 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> dtoList = scheduleService.findAll();

        return new ResponseEntity<>(dtoList,HttpStatus.OK);

    }


    // 선택 일정 조회
    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable("scheduleId") Long scheduleId) {

        return new ResponseEntity<>(scheduleService.findScheduleById(scheduleId), HttpStatus.OK);
    }


    //선택 일정 수정
    @PatchMapping("/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponseDto> updateSchedule(@PathVariable("scheduleId") Long id, @RequestBody CreateScheduleRequestDto dto) {

        UpdateScheduleResponseDto scheduleResponseDto =
                scheduleService.update(
                        id, dto.getTitle(), dto.getContents()
                );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }





    // 선택 일정 삭제
    @DeleteMapping("/{scheduleId}")
    public void deleteSchedule(@PathVariable("scheduleId") Long scheduleId) {

        scheduleService.deleteSchedule(scheduleId);

    }



}
