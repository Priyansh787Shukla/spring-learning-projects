package com.endeavour.crudSpringBootDemo.service;

import com.endeavour.crudSpringBootDemo.entity.Student;
import com.endeavour.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    //1. End Point Listen (/app/students POST)
    //2.Business Logic
    //3. Interact with DB (to store/update info)
    //4. Response back to client (here: postman)

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) //Create
    {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) //Read
    {
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isPresent()) return studentResp.get();
        return null;
    }

    public List<Student> getAllStudents() //Read All
    {
        return studentRepository.findAll(); //return the list of students
    }

    public Student updateStudent(Long id, Student studentReq) //updates the student details
    {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if(existingStudent==null) return null;

        existingStudent.setName(studentReq.getName());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setEmail(studentReq.getEmail());
        existingStudent.setRollno(studentReq.getRollno());

        return studentRepository.save(existingStudent);
    }

    public boolean deleteStudent(Long id) //deletes the student record
    {
        boolean isThere = studentRepository.existsById(id);
        if(!isThere) return false;
        studentRepository.deleteById(id);
        return true;
    }
}
