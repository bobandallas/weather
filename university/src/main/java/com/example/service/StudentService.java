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

    Boolean addOne(Student student);

    Boolean deleteOne(int id);

    Boolean updateOne(int id, Student student);

}
