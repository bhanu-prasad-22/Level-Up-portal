package com.levelup.levelup_portal.controller;

import com.levelup.levelup_portal.dto.InternshipDto;
import com.levelup.levelup_portal.service.InternshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internships")
@RequiredArgsConstructor
public class InternshipController {

    private final InternshipService internshipService;

    @GetMapping
    public ResponseEntity<List<InternshipDto>> getAllInternships() {
        return ResponseEntity.ok(internshipService.getAllInternships());
    }

    @PostMapping
    public ResponseEntity<InternshipDto> createInternship(@RequestBody InternshipDto internshipDto) {
        return ResponseEntity.ok(internshipService.createInternship(internshipDto));
    }
}
