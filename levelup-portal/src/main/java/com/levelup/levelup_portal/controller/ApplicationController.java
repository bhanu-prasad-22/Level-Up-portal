package com.levelup.levelup_portal.controller;

import com.levelup.levelup_portal.dto.ApplicationDto;
import com.levelup.levelup_portal.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(applicationService.getApplicationsByUser(userId));
    }

    @GetMapping("/internship/{internshipId}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByInternship(@PathVariable Long internshipId) {
        return ResponseEntity.ok(applicationService.getApplicationsByInternship(internshipId));
    }

    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto) {
        return ResponseEntity.ok(applicationService.createApplication(applicationDto));
    }
}
