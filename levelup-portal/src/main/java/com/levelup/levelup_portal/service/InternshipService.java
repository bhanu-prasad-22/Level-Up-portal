package com.levelup.levelup_portal.service;

import com.levelup.levelup_portal.dto.InternshipDto;
import com.levelup.levelup_portal.entity.Internship;
import com.levelup.levelup_portal.repository.InternshipRepository;
import com.levelup.levelup_portal.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepo;

    public InternshipService(InternshipRepository internshipRepo) {
        this.internshipRepo = internshipRepo;
    }

    public List<InternshipDto> getAllInternships() {
        return internshipRepo.findAll().stream()
                .map(DtoMapper::toInternshipDto)
                .collect(Collectors.toList());
    }

    public InternshipDto createInternship(InternshipDto dto) {
        Internship internship = DtoMapper.toInternshipEntity(dto);
        return DtoMapper.toInternshipDto(internshipRepo.save(internship));
    }
}
