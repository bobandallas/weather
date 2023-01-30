package com.example.repository;

import com.example.pojo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository{
    String deleteOne(int id);

    String addOne(Student student);

    String updateOne(int id, Student student);

    List<Student> findAll();

    Student getById(int id);

}


