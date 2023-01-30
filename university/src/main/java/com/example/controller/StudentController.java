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

    @PutMapping
    public ResponseEntity<String> addOne(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addOne(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable int id){
        return new ResponseEntity<>(studentService.deleteOne(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> updateOne(@PathVariable int id,@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateOne(id, student), HttpStatus.OK);
    }

//    CustomGlobalExceptionHandler
}
