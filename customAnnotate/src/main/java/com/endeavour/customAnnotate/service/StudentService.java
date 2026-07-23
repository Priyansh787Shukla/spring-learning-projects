package com.endeavour.customAnnotate.service;

import com.endeavour.customAnnotate.annotation.TrackTime;
import com.endeavour.customAnnotate.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @TrackTime
    public Student create(Student student)
    {
        try
        {
            Thread.sleep(1500);
        }
        catch(Exception e) {}
        System.out.println("Student Saved");
        return student;
    }
}
