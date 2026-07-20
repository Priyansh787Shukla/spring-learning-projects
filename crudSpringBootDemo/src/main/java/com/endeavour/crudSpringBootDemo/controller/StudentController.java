package com.endeavour.crudSpringBootDemo.controller;

import com.endeavour.crudSpringBootDemo.entity.Student;
import com.endeavour.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping("/create") //Create //can also do @PostMapping("/create") or @RequestMapping("/create") for /api/students/create
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        Student studentResp = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResp);
    }

    @GetMapping("/get/{id}") //Read
    public ResponseEntity<Student> getStudent(@PathVariable Long id)
    {
        Student studentResp = studentService.getStudent(id);
        if(studentResp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/getAll") //Read All
    public ResponseEntity<List<Student>> getAllStudents()
    {
        List<Student> students = studentService.getAllStudents();
        if(students.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student)
    {
        Student studentResp = studentService.updateStudent(id, student);
        if(studentResp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id)
    {
        boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Record Deleted");
    }
}
