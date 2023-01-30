package com.example.service;

import com.example.pojo.dto.StudentResponseDTO;
import com.example.pojo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
//    void add();
//    void delete();

    StudentResponseDTO.StudentDTO getById(int id);

    StudentResponseDTO findAll();

    String addOne(Student student);

    String deleteOne(int id);

    String updateOne(int id, Student student);

}
