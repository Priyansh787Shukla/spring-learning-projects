package com.endeavour.SpringBootDemo2.Controller;

import com.endeavour.SpringBootDemo2.Entity.Student;
import com.endeavour.SpringBootDemo2.Service.StudentService;
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

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student st) //create
    {
        Student resp = studentService.create(st);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) //read
    {
        Student resp = studentService.get(id);
        if(resp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll() //read all
    {
        List<Student> list = studentService.getAll();
        if(list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student st)
    {
        Student resp = studentService.update(id, st);
        if(resp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        boolean deleted = studentService.delete(id);
        if(!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Student Deleted");
    }
}
