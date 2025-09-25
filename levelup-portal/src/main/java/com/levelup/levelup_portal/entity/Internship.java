package com.levelup.levelup_portal.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String title;

    private String description;

    private String skillsRequired;

    private LocalDateTime deadline;


}
