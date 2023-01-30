package com.example.search.controller;

import com.example.search.domain.dto.ResponseDTO;
import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private final SearchService searchService;
    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO> getDetails() {
        //TODO
        return new ResponseEntity<>(searchService.searchFunction(), HttpStatus.OK);
    }
}
