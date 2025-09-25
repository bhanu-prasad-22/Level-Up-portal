package com.levelup.levelup_portal.service;

import com.levelup.levelup_portal.dto.QuestDto;
import com.levelup.levelup_portal.entity.Quest;
import com.levelup.levelup_portal.entity.Skill;
import com.levelup.levelup_portal.entity.User;
import com.levelup.levelup_portal.mapper.DtoMapper;
import com.levelup.levelup_portal.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestService {

    private final QuestRepository questRepo;
    private final UserRepository userRepo;
    private final SkillRepository skillRepo;

    public QuestService(QuestRepository questRepo, UserRepository userRepo, SkillRepository skillRepo) {
        this.questRepo = questRepo;
        this.userRepo = userRepo;
        this.skillRepo = skillRepo;
    }

    public List<QuestDto> getAllQuests() {
        return questRepo.findAll().stream()
                .map(DtoMapper::toQuestDto)
                .collect(Collectors.toList());
    }

    public List<QuestDto> getQuestsByUser(Long userId) {
        return questRepo.findByUserId(userId).stream()
                .map(DtoMapper::toQuestDto)
                .collect(Collectors.toList());
    }

    public List<QuestDto> getQuestsBySkill(Long skillId) {
        return questRepo.findBySkillId(skillId).stream()
                .map(DtoMapper::toQuestDto)
                .collect(Collectors.toList());
    }

    public QuestDto createQuest(QuestDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        Skill skill = skillRepo.findById(dto.getSkillId()).orElseThrow();
        Quest quest = DtoMapper.toQuestEntity(dto, user, skill);
        return DtoMapper.toQuestDto(questRepo.save(quest));
    }
}
