package com.endeavour.interceptor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    @PostMapping
    public ResponseEntity<String> create()
    {
        System.out.println("Controller Called");
        return ResponseEntity.ok("Student Created");
    }
}
