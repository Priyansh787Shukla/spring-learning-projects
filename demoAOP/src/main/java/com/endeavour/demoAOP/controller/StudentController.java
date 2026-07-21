package com.endeavour.demoAOP.controller;

import com.endeavour.demoAOP.dto.Student;
import com.endeavour.demoAOP.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Student> create(@RequestBody Student student)
    {
        return ResponseEntity.ok(studentService.create(student));
    }

    @GetMapping
    public ResponseEntity<String> get()
    {
        String s = "Aditya";
        return ResponseEntity.ok(studentService.get(s));
    }
}
