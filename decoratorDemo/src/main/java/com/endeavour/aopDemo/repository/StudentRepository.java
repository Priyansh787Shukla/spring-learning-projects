package com.endeavour.aopDemo.repository;

import com.endeavour.aopDemo.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository
{
    public void save(Student student)
    {
        System.out.println("Student Saved Successfully");
    }
}
