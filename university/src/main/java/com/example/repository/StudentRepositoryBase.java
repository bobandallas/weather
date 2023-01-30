package com.example.repository;

import com.example.pojo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryBase extends JpaRepository<Student, Integer> {

}