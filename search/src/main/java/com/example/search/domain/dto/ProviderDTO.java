package com.example.search.domain.dto;

import com.example.search.domain.entity.Provider;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProviderDTO {
    @JsonProperty("data")
    private List<Provider> data;
}
