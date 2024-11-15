package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponseDto {

    private final Long id;
    private final String title;
    private final String contents;
    private final String username;
    private final LocalDateTime updated;

    public UpdateScheduleResponseDto(Long id, String title, String contents, String username, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.updated = updated;
    }
}
