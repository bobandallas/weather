package com.example.service.impl;

import com.example.pojo.dto.TeacherResponseDTO;
import com.example.pojo.entity.Teacher;
import com.example.repository.TeacherRepository;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TeacherResponseDTO.TeacherDTO getById(int id) {
        Teacher teacher = teacherRepository.getById(id);
        return new TeacherResponseDTO.TeacherDTO(teacher);
    }


    @Override
    public TeacherResponseDTO getAll() {
        List<Teacher> temp = teacherRepository.getAll();;
        List<TeacherResponseDTO.TeacherDTO> res = temp.stream()
                .map(e -> new TeacherResponseDTO.TeacherDTO(e))
                .collect(Collectors.toList());

        return new TeacherResponseDTO(res);
    }
    @Override
    @Transactional
    public Boolean addOne( Teacher teacher){
        teacherRepository.addOne(teacher);
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteOne(int id){
        teacherRepository.deleteOne(id);
        return true;
    }

    @Override
    @Transactional
    public Boolean updateOne(int id,  Teacher teacher){
        teacherRepository.updateOne(id, teacher);
        return true;
    }

}
