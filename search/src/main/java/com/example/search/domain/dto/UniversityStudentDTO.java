package com.example.search.domain.dto;

import com.example.search.domain.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UniversityStudentDTO {

    @JsonProperty
    List<Student> data;
}
