// InternshipDTO.java
package com.levelup.levelup_portal.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InternshipDto {
    private Long id;
    private String companyName;
    private String title;
    private String description;
    private String skillsRequired;
    private LocalDateTime deadline;
}
