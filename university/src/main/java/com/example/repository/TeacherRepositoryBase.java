package com.example.repository;

import com.example.pojo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositoryBase extends JpaRepository<Teacher, Integer> {

}
