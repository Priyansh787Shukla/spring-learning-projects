package com.endeavour.jpaRelationships.repository;

import com.endeavour.jpaRelationships.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Department department)
    {
        entityManager.persist(department);
    }

    public Department getById(Long id)
    {
        return entityManager.find(Department.class, id);
    }
}
