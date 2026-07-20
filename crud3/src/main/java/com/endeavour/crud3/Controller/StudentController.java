package com.endeavour.crud3.Controller;

import com.endeavour.crud3.Entity.Student;
import com.endeavour.crud3.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private final StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }


    /**CREATE OPERATION*/

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student st)
    {
        Student resp = studentService.create(st);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }


    /**READ OPERATION*/

    @GetMapping("/read")
    public ResponseEntity<Student> read(@RequestParam long id)
    {
        Student resp = studentService.read(id);
        if(resp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resp);
    }


    /**READ-ALL OPERATION*/

    @GetMapping("/readAll")
    public ResponseEntity<List<Student>> readAll()
    {
        List<Student> list = studentService.readAll();
        if(list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(list);
    }


    /**UPDATE OPERATION*/

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestParam Long id, @RequestBody Student st)
    {
        Student resp = studentService.update(id, st);
        if(resp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resp);
    }


    /**DELETE OPERATION*/

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id)
    {
        boolean resp = studentService.delete(id);
        if(!resp) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Student Record Deleted");
    }


    /**SOFT DELETE*/

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> softDelete(@RequestParam Long id)
    {
        boolean deleted = studentService.softDelete(id);
        if(!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Student Record Soft Deleted");
    }
}
