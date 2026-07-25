package com.endeavour.springJDBCdemo.service;

import com.endeavour.springJDBCdemo.entity.Student;
import com.endeavour.springJDBCdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class StudentService
{
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public String create(Student student)
    {
        return studentRepository.create(student);
    }

    public Student get(long id)
    {
        return studentRepository.get(id);
    }

    public List<Student> getAll()
    {
        return studentRepository.getAll();
    }

    public String update(Student student, long id)
    {
        return studentRepository.update(student, id);
    }

    public String delete(long id)
    {
        return studentRepository.delete(id);
    }
}
