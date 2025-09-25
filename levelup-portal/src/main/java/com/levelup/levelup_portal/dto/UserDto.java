// UserDTO.java
package com.levelup.levelup_portal.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Integer level;
    private Integer totalXP;
    private List<SkillDto> skills; // nested DTOs
}
