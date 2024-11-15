package com.example.scheduledevelop.repository;

import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Optional<Schedule> findById(Long id);

    default Schedule findScheduleByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(()->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));

    }

}
