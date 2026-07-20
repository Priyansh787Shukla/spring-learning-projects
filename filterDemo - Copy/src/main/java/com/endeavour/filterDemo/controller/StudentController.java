package com.endeavour.filterDemo.controller;

import com.endeavour.filterDemo.entity.Student;
import com.endeavour.filterDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    StudentService studentService;;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student)
    {
        studentService.create(student);
        return ResponseEntity.ok("Done");
    }
}
