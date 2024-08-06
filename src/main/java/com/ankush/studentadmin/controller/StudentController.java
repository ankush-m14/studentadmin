package com.ankush.studentadmin.controller;

import com.ankush.studentadmin.model.Student;
import com.ankush.studentadmin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student){
      studentService.saveStudent(student);
      return new ResponseEntity<>("Student Information added successfully",
                              HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>( studentService.getAllStudent(),HttpStatus.OK);
    }

}
