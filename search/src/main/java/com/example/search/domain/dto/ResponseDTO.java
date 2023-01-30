package com.example.search.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private ProviderDTO provider;

    private UniversityStudentDTO student;

    private UniversityTeacherDTO teacher;
}
