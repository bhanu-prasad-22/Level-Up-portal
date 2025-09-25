package com.levelup.levelup_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {
    private boolean success;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}