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
    public ResponseEntity addOne(@RequestBody Teacher teacher){

        try {
            Boolean result = teacherService.addOne(teacher);
            if(result){
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();



    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable int id){

        try {
            Boolean result = teacherService.deleteOne(id);
            if(result){
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOne(@PathVariable int id,@RequestBody Teacher teacher){
        try {
            Boolean result = teacherService.updateOne(id, teacher);
            if(result){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
