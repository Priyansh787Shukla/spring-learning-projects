package com.endeavour.springJDBCdemo.controller;

import com.endeavour.springJDBCdemo.entity.Student;
import com.endeavour.springJDBCdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/api/students"))
public class StudentController
{
    private StudentService studentService;
    public  StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student)
    {
        return ResponseEntity.ok(studentService.create(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable long id)
    {
        return ResponseEntity.ok(studentService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll()
    {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Student student, @PathVariable long id)
    {
        return ResponseEntity.ok(studentService.update(student, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id)
    {
        return ResponseEntity.ok(studentService.delete(id));
    }
}
