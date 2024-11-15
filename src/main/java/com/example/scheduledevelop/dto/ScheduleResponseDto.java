package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final String username;
    private final LocalDateTime createdAt;

    public ScheduleResponseDto(Long id, String title, String contents, String username, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.createdAt = createdAt;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getUser().getUsername(),
                schedule.getUpdatedDate()
        );
    }
}
