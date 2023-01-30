package com.example.service;

import com.example.pojo.dto.UserResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponseDTO getAll();
    Boolean insertOne(UserResponseDTO.UserDTO user);

}
