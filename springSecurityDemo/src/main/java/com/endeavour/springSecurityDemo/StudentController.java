package com.endeavour.springSecurityDemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    @GetMapping
    public ResponseEntity<String> get()
    {
        return ResponseEntity.ok("Student Retrieved Successfully");
    }
}
