package com.example.pojo.dto;


import com.example.pojo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
    private List<StudentDTO> data;


    @Data
    @Builder
    @AllArgsConstructor
    public static class StudentDTO{
        private int id;
        private String name;

        private int age;

        public StudentDTO(Student s){
            this.id = s.getId();
            this.name = s.getName();
            this.age = s.getAge();
        }
    }

}
