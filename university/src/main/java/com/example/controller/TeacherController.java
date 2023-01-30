package com.example.controller;

import com.example.pojo.dto.TeacherResponseDTO;
import com.example.pojo.entity.Teacher;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO.TeacherDTO> getTeacherById(@PathVariable int id){
        return new ResponseEntity<>(teacherService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TeacherResponseDTO> getAll(){
        return new ResponseEntity<>(teacherService.getAll(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> addOne(@RequestBody Teacher teacher){


        return new ResponseEntity<>(teacherService.addOne(teacher), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable int id){
        return new ResponseEntity<>(teacherService.deleteOne(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOne(@PathVariable int id,@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.updateOne(id, teacher), HttpStatus.OK);
    }
}
