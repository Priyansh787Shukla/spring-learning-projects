package com.endeavour.jpaRelationships.controller;

import com.endeavour.jpaRelationships.entity.Department;
import com.endeavour.jpaRelationships.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController
{
    private DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Department department)
    {
        departmentService.create(department);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/withStudent")
    public ResponseEntity<String> create(@RequestBody Department department, @RequestParam String studentName)
    {
        departmentService.create(department, studentName);
        return ResponseEntity.ok("DONE");
    }
}
