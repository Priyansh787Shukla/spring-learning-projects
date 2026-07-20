package com.endeavour.SpringBootDemo2.Repository;

import com.endeavour.SpringBootDemo2.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>
{
    //
}
