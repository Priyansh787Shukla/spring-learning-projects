package com.endeavour.crud3.Service;

import com.endeavour.crud3.Entity.Student;
import com.endeavour.crud3.Repository.StudentRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService
{
    private StudentRepo repo;
    public StudentService(StudentRepo repo)
    {
        this.repo = repo;
    }

     /**CREATE*/
     public Student create(Student st)
     {
         st.setDeleted(false);
         return repo.save(st);
     }

     /**READ*/
     public Student read(Long id)
     {
         return repo.findByIdAndDeletedIsFalse(id);
     }

     /**READ-ALL*/
     public List<Student> readAll()
     {
         return repo.findByDeletedIsFalse();
     }

     /**UPDATE*/
     public Student update(Long id, Student st)
     {
         Student resp = repo.findByIdAndDeletedIsFalse(id);
         if(resp==null) return null;
         resp.setName(st.getName());
         resp.setAge(st.getAge());
         resp.setDeleted(false);
         return repo.save(resp);
     }

     /**DELETE*/
     public boolean delete(Long id)
     {
         Student exists = repo.findById(id).orElse(null);
         if(exists==null) return false;
         repo.deleteById(id);
         return true;
     }

     /**SOFT-DELETE*/
     public boolean softDelete(Long id)
     {
         //get record
         //update deleted from 0 to 1
         //save updated record

         Student resp = repo.findByIdAndDeletedIsFalse(id);
         if(resp==null) return false;
         resp.setDeleted(true);
         repo.save(resp);
         return true;
     }
}
