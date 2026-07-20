package com.endeavour.crud3.Repository;

import com.endeavour.crud3.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long>
{
    Student findByIdAndDeletedIsFalse(Long id);
    List<Student> findByDeletedIsFalse();

    //findBY + fieldName + condition
}
