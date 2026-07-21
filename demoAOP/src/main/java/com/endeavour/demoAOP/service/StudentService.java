package com.endeavour.demoAOP.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    //target
    public String create()
    {
        System.out.println("Student Saved");
        return "Student Saved";
    }
}
