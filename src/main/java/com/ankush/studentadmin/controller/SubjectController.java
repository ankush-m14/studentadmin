package com.ankush.studentadmin.controller;


import com.ankush.studentadmin.model.Subject;
import com.ankush.studentadmin.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("/create")
    public ResponseEntity<String> createSubject(@RequestBody Subject subject) {
        subjectService.saveSubject(subject);
        return new ResponseEntity<>("Subject added successfully",
                                      HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<>(subjectService.getAllSubject(), HttpStatus.OK);
    }


}
