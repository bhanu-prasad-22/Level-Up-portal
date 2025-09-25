// ApplicationDTO.java
package com.levelup.levelup_portal.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApplicationDto {
    private Long id;
    private String status;
    private LocalDateTime submissionDate;
    private Long userId;
    private Long internshipId;
}
