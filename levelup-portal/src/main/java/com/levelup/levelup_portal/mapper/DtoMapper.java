package com.levelup.levelup_portal.mapper;

import com.levelup.levelup_portal.dto.*;
import com.levelup.levelup_portal.entity.*;

import java.util.stream.Collectors;

public class DtoMapper {

    // ===== User =====
    public static UserDto toUserDto(User user) {
        if (user == null) return null;
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setLevel(user.getLevel());
        dto.setTotalXP(user.getTotalXP());
        if (user.getSkills() != null) {
            dto.setSkills(user.getSkills().stream()
                    .map(DtoMapper::toSkillDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static User toUserEntity(UserDto dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setLevel(dto.getLevel());
        user.setTotalXP(dto.getTotalXP());
        // password not exposed in DTO → keep null or handle elsewhere
        return user;
    }

    // ===== Skill =====
    public static SkillDto toSkillDto(Skill skill) {
        if (skill == null) return null;
        SkillDto dto = new SkillDto();
        dto.setId(skill.getId());
        dto.setType(skill.getType());
        dto.setLevel(skill.getLevel());
        dto.setXp(skill.getXp());
        dto.setUserId(skill.getUser() != null ? skill.getUser().getId() : null);
        if (skill.getQuests() != null) {
            dto.setQuests(skill.getQuests().stream()
                    .map(DtoMapper::toQuestDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static Skill toSkillEntity(SkillDto dto, User user) {
        if (dto == null) return null;
        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setType(dto.getType());
        skill.setLevel(dto.getLevel());
        skill.setXp(dto.getXp());
        skill.setUser(user);
        return skill;
    }

    // ===== Quest =====
    public static QuestDto toQuestDto(Quest quest) {
        if (quest == null) return null;
        QuestDto dto = new QuestDto();
        dto.setId(quest.getId());
        dto.setTitle(quest.getTitle());
        dto.setDescription(quest.getDescription());
        dto.setType(quest.getType());
        dto.setStatus(quest.getStatus());
        dto.setRewardXP(quest.getRewardXP());
        dto.setDeadline(quest.getDeadline());
        dto.setUserId(quest.getUser() != null ? quest.getUser().getId() : null);   // 👈 map userId
        dto.setSkillId(quest.getSkill() != null ? quest.getSkill().getId() : null); // 👈 map skillId

        return dto;
    }

    public static Quest toQuestEntity(QuestDto dto, User user, Skill skill) {
        if (dto == null) return null;
        Quest quest = new Quest();
        quest.setId(dto.getId());
        quest.setTitle(dto.getTitle());
        quest.setDescription(dto.getDescription());
        quest.setType(dto.getType());
        quest.setStatus(dto.getStatus());
        quest.setRewardXP(dto.getRewardXP());
        quest.setDeadline(dto.getDeadline());
        quest.setUser(user);
        quest.setSkill(skill);
        return quest;
    }

    // ===== Internship =====
    public static InternshipDto toInternshipDto(Internship internship) {
        if (internship == null) return null;
        InternshipDto dto = new InternshipDto();
        dto.setId(internship.getId());
        dto.setCompanyName(internship.getCompanyName());
        dto.setTitle(internship.getTitle());
        dto.setDescription(internship.getDescription());
        dto.setSkillsRequired(internship.getSkillsRequired());
        dto.setDeadline(internship.getDeadline());
        return dto;
    }

    public static Internship toInternshipEntity(InternshipDto dto) {
        if (dto == null) return null;
        Internship internship = new Internship();
        internship.setId(dto.getId());
        internship.setCompanyName(dto.getCompanyName());
        internship.setTitle(dto.getTitle());
        internship.setDescription(dto.getDescription());
        internship.setSkillsRequired(dto.getSkillsRequired());
        internship.setDeadline(dto.getDeadline());
        return internship;
    }

    // ===== Application =====
    public static ApplicationDto toApplicationDto(Application app) {
        if (app == null) return null;
        ApplicationDto dto = new ApplicationDto();
        dto.setId(app.getId());
        dto.setStatus(app.getStatus());
        dto.setSubmissionDate(app.getSubmissionDate());
        dto.setUserId(app.getUser() != null ? app.getUser().getId() : null);
        dto.setInternshipId(app.getInternship() != null ? app.getInternship().getId() : null);
        return dto;
    }

    public static Application toApplicationEntity(ApplicationDto dto, User user, Internship internship) {
        if (dto == null) return null;
        Application app = new Application();
        app.setId(dto.getId());
        app.setStatus(dto.getStatus());
        app.setSubmissionDate(dto.getSubmissionDate());
        app.setUser(user);
        app.setInternship(internship);
        return app;
    }
}
