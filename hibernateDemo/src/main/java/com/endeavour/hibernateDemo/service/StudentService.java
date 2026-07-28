package com.endeavour.hibernateDemo.service;

import com.endeavour.hibernateDemo.entity.Student;
import com.endeavour.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void create(Student st)
    {
        studentRepository.create(st);
    }

    @Transactional
    public Student get(long id)
    {
        return studentRepository.get(id);
    }

    @Transactional
    public void update(Student st, long id)
    {
        Student st1 = studentRepository.get(id);
        if(st1==null) throw new RuntimeException("Student not found");
        st1.setName(st.getName());
        st1.setAge(st.getAge());
        st1.setEmail(st.getEmail());
    }

    @Transactional
    public void delete(long id)
    {
        Student st1 = studentRepository.get(id);
        if(st1==null) throw new RuntimeException("Student not found");
        studentRepository.delete(st1);
    }
}
