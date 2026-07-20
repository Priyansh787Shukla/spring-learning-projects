package com.endeavour.aopDemo.controller;

import com.endeavour.aopDemo.dto.Student;
import com.endeavour.aopDemo.service.LoggingDecorator;
import com.endeavour.aopDemo.service.StudentService;
import com.endeavour.aopDemo.service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private StudentService studentService;

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
