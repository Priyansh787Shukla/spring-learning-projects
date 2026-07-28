package com.endeavour.hibernateDemo.repository;

import com.endeavour.hibernateDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Student st)
    {
        entityManager.persist(st);
    }

    public Student get(long id)
    {
        return entityManager.find(Student.class, id);
    }

    public void delete(Student st)
    {
        entityManager.remove(st);
    }
}
