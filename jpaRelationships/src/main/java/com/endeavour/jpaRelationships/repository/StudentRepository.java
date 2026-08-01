package com.endeavour.jpaRelationships.repository;

import com.endeavour.jpaRelationships.entity.Department;
import com.endeavour.jpaRelationships.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Student student)
    {
        entityManager.persist(student);
    }
}
