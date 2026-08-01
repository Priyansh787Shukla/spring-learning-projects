package com.endeavour.jpaRelationships.service;

import com.endeavour.jpaRelationships.entity.Department;
import com.endeavour.jpaRelationships.entity.Student;
import com.endeavour.jpaRelationships.repository.DepartmentRepository;
import com.endeavour.jpaRelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService
{
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;
    public DepartmentService(DepartmentRepository departmentRepository,  StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void create(Department department)
    {
        departmentRepository.create(department);
    }

    @Transactional
    public void create(Department department, String studentName)
    {
        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);
        System.out.println(department.getStudents());
        department.getStudents().add(student);
        studentRepository.create(student);
        departmentRepository.create(department);
    }
}
