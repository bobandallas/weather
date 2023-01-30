package com.example.repository.impl;

import com.example.pojo.entity.Teacher;
import com.example.repository.TeacherRepository;
import com.example.repository.impl.ORMconfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    private ORMconfig em = ORMconfig.getInstance();

    @Override
    public Teacher getById(int id){
        return em.getById(id);
    }


    @Override
    public List<Teacher> getAll(){
        return em.getAll();
    }


    @Override
    public String addOne(Teacher teacher) {
        return em.addOne(teacher);
    }

    @Override
    public String updateOne(int id, Teacher teacher) {
        return em.updateOne(id, teacher);
    }


    @Override
    public String deleteOne(int id){
        return em.deleteOne(id);
    }
}
