package com.levelup.levelup_portal.service;

import com.levelup.levelup_portal.dto.SkillDto;
import com.levelup.levelup_portal.entity.Skill;
import com.levelup.levelup_portal.entity.User;
import com.levelup.levelup_portal.repository.SkillRepository;
import com.levelup.levelup_portal.mapper.DtoMapper;
import com.levelup.levelup_portal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepo;
    private final UserRepository userRepo;

    public SkillService(SkillRepository skillRepo, UserRepository userRepo) {
        this.skillRepo = skillRepo;
        this.userRepo = userRepo;
    }

    public List<SkillDto> getAllSkills() {
        return skillRepo.findAll().stream()
                .map(DtoMapper::toSkillDto)
                .collect(Collectors.toList());
    }

    public List<SkillDto> getSkillsByUser(Long userId) {
        return skillRepo.findByUserId(userId).stream()
                .map(DtoMapper::toSkillDto)
                .collect(Collectors.toList());
    }

    public SkillDto createSkill(SkillDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        Skill skill = DtoMapper.toSkillEntity(dto, user);
        return DtoMapper.toSkillDto(skillRepo.save(skill));
    }
}
