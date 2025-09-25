package com.levelup.levelup_portal.controller;

import com.levelup.levelup_portal.dto.SkillDto;
import com.levelup.levelup_portal.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAllSkills() {
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillDto>> getSkillsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(skillService.getSkillsByUser(userId));
    }

    @PostMapping
    public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto skillDto) {
        return ResponseEntity.ok(skillService.createSkill(skillDto));
    }
}
