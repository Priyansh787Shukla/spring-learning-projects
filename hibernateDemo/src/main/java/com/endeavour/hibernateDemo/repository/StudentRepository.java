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
        Student s1 = entityManager.find(Student.class, id);
        //entityManager.detach(s1); //detaches s1 from persistence context
        //entityManager.merge(); - re-attaches s1 to persistence context
        //entityManager.clear(); - detaches all objects from persistence context
        //entityManager.flush(); - syncs the DB with Persistence context
        //entityManager.remove(s1); - deleted s1 from DB
        return s1;
    }

    public void delete(Student st)
    {
        entityManager.remove(st);
    }
}
