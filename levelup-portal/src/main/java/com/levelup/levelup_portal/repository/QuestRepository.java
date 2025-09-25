package com.levelup.levelup_portal.repository;

import com.levelup.levelup_portal.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Long> {
    List<Quest> findByUserId(Long userId);
    List<Quest> findBySkillId(Long skillId);
}
