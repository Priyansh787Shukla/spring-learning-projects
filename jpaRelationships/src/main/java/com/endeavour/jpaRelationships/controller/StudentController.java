package com.endeavour.jpaRelationships.controller;

import com.endeavour.jpaRelationships.entity.Student;
import com.endeavour.jpaRelationships.service.StudentService;
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
    public ResponseEntity<String> create(@RequestBody Student student, @RequestParam Long id)
    {
        studentService.create(student, id);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String> create(@RequestBody Student student, @RequestParam String deptName)
    {
        studentService.create(student, deptName);
        return ResponseEntity.ok("DONE");
    }
}
