package com.example.pojo.dto;


import com.example.pojo.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class TeacherResponseDTO {
    private final List<TeacherDTO> data;


    @Data
    @AllArgsConstructor
    @Builder
    public static class TeacherDTO{


        private final String name;

        private final int age;

        private final String gender;
        public TeacherDTO(Teacher teacher){
            this.name = teacher.getName();
            this.age = teacher.getAge();
            this.gender = teacher.getGender();
        }
    }


}
