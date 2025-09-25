package com.levelup.levelup_portal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String type; // Main / Side
    private String status; // OPEN / IN_PROGRESS / DONE
    private Integer rewardXP;
    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    @JsonBackReference
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore   // prevent recursion User -> Skill -> Quest -> User...
    private User user;

}
