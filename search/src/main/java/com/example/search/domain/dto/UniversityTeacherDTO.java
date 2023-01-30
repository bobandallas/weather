package com.example.search.domain.dto;

import com.example.search.domain.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UniversityTeacherDTO {

    @JsonProperty
    List<Teacher> data;
}
