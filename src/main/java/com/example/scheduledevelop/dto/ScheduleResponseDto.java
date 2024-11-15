package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Schedule;

public class ScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String username;

    public ScheduleResponseDto(Long id, String title, String content, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getUser().getUsername());
    }
}
