package com.levelup.levelup_portal.repository;

import com.levelup.levelup_portal.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByUserId(Long userId);
    List<Application> findByInternshipId(Long internshipId);
}
