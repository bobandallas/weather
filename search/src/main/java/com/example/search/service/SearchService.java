package com.example.search.service;

import com.example.search.domain.dto.ResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface SearchService {
    ResponseDTO searchFunction();
}
