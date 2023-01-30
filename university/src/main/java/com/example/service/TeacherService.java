package com.example.service;

import com.example.pojo.dto.TeacherResponseDTO;
import com.example.pojo.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    TeacherResponseDTO.TeacherDTO getById(int id);

    TeacherResponseDTO getAll();

    Boolean addOne(Teacher teacher);

    Boolean deleteOne(int id);

    Boolean updateOne(int id, Teacher teacher);
}
