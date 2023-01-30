package com.example.pojo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UserRequestDTO {


    private UserResponseDTO.UserDTO provider;

}
