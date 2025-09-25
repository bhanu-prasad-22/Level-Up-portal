package com.levelup.levelup_portal.controller;

import com.levelup.levelup_portal.dto.QuestDto;
import com.levelup.levelup_portal.service.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quests")
@RequiredArgsConstructor
public class QuestController {

    private final QuestService questService;

    @GetMapping
    public ResponseEntity<List<QuestDto>> getAllQuests() {
        return ResponseEntity.ok(questService.getAllQuests());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<QuestDto>> getQuestsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(questService.getQuestsByUser(userId));
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<QuestDto>> getQuestsBySkill(@PathVariable Long skillId) {
        return ResponseEntity.ok(questService.getQuestsBySkill(skillId));
    }

    @PostMapping
    public ResponseEntity<QuestDto> createQuest(@RequestBody QuestDto questDto) {
        return ResponseEntity.ok(questService.createQuest(questDto));
    }
}
