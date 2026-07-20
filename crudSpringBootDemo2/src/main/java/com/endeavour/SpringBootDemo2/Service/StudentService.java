package com.endeavour.SpringBootDemo2.Service;

import com.endeavour.SpringBootDemo2.Entity.Student;
import com.endeavour.SpringBootDemo2.Repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService
{
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public Student create(Student st) //create
    {
        return studentRepository.save(st);
    }

    public Student get(long id) //read
    {
        return studentRepository.findById(id).orElse(null);
        /**
         * Can Also Write:
        Optional<Student> resp = studentRepository.findById(id);
        if(resp.isPresent()) return resp.get();
        return null;
        */
    }

    public List<Student> getAll()
    {
        return studentRepository.findAll();
    }

    public Student update(long id, Student st) //update
    {
        Student resp = studentRepository.findById(id).orElse(null);
        if(resp==null) return null;
        resp.setName(st.getName());
        resp.setEmail(st.getEmail());
        resp.setPhone(st.getPhone());
        return studentRepository.save(resp);
    }

    public boolean delete(Long id) //delete
    {
        boolean exists = studentRepository.existsById(id);
        if(!exists) return false;
        studentRepository.deleteById(id);
        return true;
    }
}
