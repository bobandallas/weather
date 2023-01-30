package com.example.controller;

import com.example.pojo.dto.StudentResponseDTO;
import com.example.pojo.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO.StudentDTO> getEmpById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<StudentResponseDTO> getAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addOne(@RequestBody Student student){
        try {
            Boolean result = studentService.addOne(student);
            if(result){
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable int id){
        try {
            Boolean result = studentService.deleteOne(id);
            if(result){
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOne(@PathVariable int id,@RequestBody Student student){
        try {
            Boolean result = studentService.updateOne(id, student);
            if(result){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

//    CustomGlobalExceptionHandler
}
