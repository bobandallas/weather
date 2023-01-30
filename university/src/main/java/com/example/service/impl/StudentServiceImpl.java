package com.example.service.impl;

import com.example.pojo.dto.StudentResponseDTO;
import com.example.pojo.entity.Student;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO.StudentDTO getById(int id) {
        Student student = studentRepository.getById(id);
        return new StudentResponseDTO.StudentDTO(student);
    }
    @Override
    public StudentResponseDTO findAll(){
        List<Student> temp = studentRepository.findAll();
        List<StudentResponseDTO.StudentDTO> res = temp.stream()
                                    .map(e -> new StudentResponseDTO.StudentDTO(e))
                                    .collect(Collectors.toList());


        return new StudentResponseDTO(res);
    }

    @Override
    public String addOne(Student student){
        studentRepository.addOne(student);
        return "success";
    }

    @Override
    public String deleteOne(int id){
        studentRepository.deleteOne(id);
        return "success";
    }

    @Override
    public String updateOne(int id, Student student){
        studentRepository.updateOne(id, student);
        return "success";
    }
}
