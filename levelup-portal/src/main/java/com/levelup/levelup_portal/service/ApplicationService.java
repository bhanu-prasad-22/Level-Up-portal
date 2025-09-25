package com.levelup.levelup_portal.service;

import com.levelup.levelup_portal.dto.ApplicationDto;
import com.levelup.levelup_portal.entity.*;
import com.levelup.levelup_portal.repository.*;
import com.levelup.levelup_portal.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepo;
    private final UserRepository userRepo;
    private final InternshipRepository internshipRepo;

    public ApplicationService(ApplicationRepository applicationRepo, UserRepository userRepo, InternshipRepository internshipRepo) {
        this.applicationRepo = applicationRepo;
        this.userRepo = userRepo;
        this.internshipRepo = internshipRepo;
    }

    public List<ApplicationDto> getAllApplications() {
        return applicationRepo.findAll().stream()
                .map(DtoMapper::toApplicationDto)
                .collect(Collectors.toList());
    }

    public List<ApplicationDto> getApplicationsByUser(Long userId) {
        return applicationRepo.findByUserId(userId).stream()
                .map(DtoMapper::toApplicationDto)
                .collect(Collectors.toList());
    }

    public List<ApplicationDto> getApplicationsByInternship(Long internshipId) {
        return applicationRepo.findByInternshipId(internshipId).stream()
                .map(DtoMapper::toApplicationDto)
                .collect(Collectors.toList());
    }

    public ApplicationDto createApplication(ApplicationDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        Internship internship = internshipRepo.findById(dto.getInternshipId()).orElseThrow();
        Application application = DtoMapper.toApplicationEntity(dto, user, internship);
        return DtoMapper.toApplicationDto(applicationRepo.save(application));
    }
}
