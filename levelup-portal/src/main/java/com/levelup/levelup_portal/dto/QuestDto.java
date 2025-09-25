// QuestDTO.java
package com.levelup.levelup_portal.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class QuestDto{
    private Long id;
    private String title;
    private String description;
    private String type;
    private String status;
    private Integer rewardXP;
    private LocalDateTime deadline;
    private Long userId;
    private Long skillId;
}
