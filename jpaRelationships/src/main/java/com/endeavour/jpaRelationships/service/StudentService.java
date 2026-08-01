package com.endeavour.jpaRelationships.service;

import com.endeavour.jpaRelationships.entity.Department;
import com.endeavour.jpaRelationships.entity.Student;
import com.endeavour.jpaRelationships.repository.DepartmentRepository;
import com.endeavour.jpaRelationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    private StudentRepository  studentRepository;
    private DepartmentRepository departmentRepository;
    public StudentService(StudentRepository studentRepository,  DepartmentRepository departmentRepository)
    {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void create(Student student, Long id)
    {
        Department department = departmentRepository.getById(id);
        student.setDepartment(department);
        department.getStudents().add(student);
        studentRepository.create(student);
    }

    @Transactional
    public void create(Student student, String deptName)
    {
        Department department = new Department();
        department.setName(deptName);
        department.getStudents().add(student);
        departmentRepository.create(department);
        student.setDepartment(department);
        studentRepository.create(student);
    }
}
