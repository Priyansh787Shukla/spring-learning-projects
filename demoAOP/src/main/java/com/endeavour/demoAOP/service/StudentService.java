package com.endeavour.demoAOP.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    public String create()
    {
        System.out.println("Student Saved");
        return "Student Saved";
    }
}
