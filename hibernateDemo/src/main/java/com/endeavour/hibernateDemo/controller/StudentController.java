package com.endeavour.hibernateDemo.controller;

import com.endeavour.hibernateDemo.entity.Student;
import com.endeavour.hibernateDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private final StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student st)
    {
        studentService.create(st);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.get(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Student st, @PathVariable Long id)
    {
        studentService.update(st, id);
        return ResponseEntity.ok("DONE");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        studentService.delete(id);
        return ResponseEntity.ok("DONE");
    }
}