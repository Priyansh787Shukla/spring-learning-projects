package com.endeavour.customAnnotate.controller;

import com.endeavour.customAnnotate.dto.Student;
import com.endeavour.customAnnotate.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/students")
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
        return ResponseEntity.ok("All Students Data");
    }
}
