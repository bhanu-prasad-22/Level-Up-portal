// SkillDTO.java
package com.levelup.levelup_portal.dto;

import lombok.Data;
import java.util.List;

@Data
public class SkillDto {
    private Long id;
    private String type;
    private Integer level;
    private Integer xp;
    private List<QuestDto> quests;// nested DTOs
    private Long userId;
}
