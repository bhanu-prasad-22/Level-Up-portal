package com.levelup.levelup_portal.service;

import com.levelup.levelup_portal.dto.* ;
import com.levelup.levelup_portal.entity.*;
import com.levelup.levelup_portal.repository.UserRepository;
import com.levelup.levelup_portal.mapper.DtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(DtoMapper::toUserDto)
                .collect(Collectors.toList());
    }


    public UserDto getUserById(Long id) {
        return userRepo.findById(id)
                .map(DtoMapper::toUserDto)
                .orElseThrow();
    }
    public UserDto getUserByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return DtoMapper.toUserDto(user);
    }


    public UserDto createUser(UserDto dto) {
        User user = DtoMapper.toUserEntity(dto);
        return DtoMapper.toUserDto(userRepo.save(user));
    }

    public UserDto updateUser(Long id, UserDto dto) {
        User user = userRepo.findById(id).orElseThrow();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        return DtoMapper.toUserDto(userRepo.save(user));
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

}
