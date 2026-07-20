package com.endeavour.crud3.Service;

import com.endeavour.crud3.Entity.Student;
import com.endeavour.crud3.Repository.StudentRepo;
import com.endeavour.crud3.dto.CreateRequestDTO;
import com.endeavour.crud3.dto.CreateResponseDTO;
import com.endeavour.crud3.dto.UpdateRequestDTO;
import com.endeavour.crud3.dto.UpdateResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
     public CreateResponseDTO create(CreateRequestDTO reqDTO)
     {
         Student req = toEntity(reqDTO);
         Student resp = repo.save(req);
         return toDTO(resp);
     }

     /**READ*/
     public CreateResponseDTO read(Long id)
     {
         return toDTO(repo.findByIdAndDeletedIsFalse(id));
     }

     /**READ-ALL*/
     public List<CreateResponseDTO> readAll()
     {
         List<Student> list =  repo.findByDeletedIsFalse();
         List<CreateResponseDTO> resp = new ArrayList<>();
         for(Student st : list)
         {
             resp.add(toDTO(st));
         }
         return resp;
     }

     /**UPDATE*/
     public UpdateResponseDTO update(Long id, UpdateRequestDTO st)
     {
         Student resp = repo.findByIdAndDeletedIsFalse(id);
         if(resp==null) return null;
         resp.setName(st.getName());
         resp.setAge(st.getAge());
         resp.setDeleted(false);
         Student student = repo.save(resp);
         return toResDTO(student);
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

     private Student toEntity(CreateRequestDTO reqDTO)
     {
         Student st = new Student();
         st.setName(reqDTO.getName());
         st.setAge(reqDTO.getAge());
         st.setDeleted(false);
         return st;
     }

     private CreateResponseDTO toDTO(Student st)
     {
         CreateResponseDTO respDTO = new CreateResponseDTO();
         respDTO.setName(st.getName());
         respDTO.setAge(st.getAge());
         respDTO.setId(st.getId());
         respDTO.setMessage("Student Saved Successfully");
         return respDTO;
     }

     private UpdateResponseDTO toResDTO(Student st)
     {
         UpdateResponseDTO obj = new UpdateResponseDTO();
         obj.setAge(st.getAge());
         obj.setName(st.getName());
         return obj;
     }
}
