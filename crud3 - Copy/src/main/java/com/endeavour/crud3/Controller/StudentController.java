package com.endeavour.crud3.Controller;

import com.endeavour.crud3.Entity.Student;
import com.endeavour.crud3.Service.StudentService;
import com.endeavour.crud3.dto.CreateRequestDTO;
import com.endeavour.crud3.dto.CreateResponseDTO;
import com.endeavour.crud3.dto.UpdateRequestDTO;
import com.endeavour.crud3.dto.UpdateResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Validation-Dependency --> Spring-Boot-Starter-Validation

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private final StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }


    /**CREATE OPERATION*/

    @PostMapping("/create")
    public ResponseEntity<CreateResponseDTO> create(@Valid @RequestBody CreateRequestDTO reqDTO)
    {
        CreateResponseDTO resp = studentService.create(reqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }


    /**READ OPERATION*/

    @GetMapping("/read")
    public ResponseEntity<CreateResponseDTO> read(@RequestParam long id)
    {
        CreateResponseDTO resp = studentService.read(id);
        if(resp==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resp);
    }


    /**READ-ALL OPERATION*/

    @GetMapping("/readAll")
    public ResponseEntity<List<CreateResponseDTO>> readAll()
    {
        List<CreateResponseDTO> list = studentService.readAll();
        if(list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(list);
    }


    /**UPDATE OPERATION*/

    @PutMapping("/update")
    public ResponseEntity<UpdateResponseDTO> update(@RequestParam Long id, @Valid @RequestBody UpdateRequestDTO reqDTO)
    {
        UpdateResponseDTO respDTO = studentService.update(id, reqDTO);
        if(respDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(respDTO);
    }


    /**DELETE OPERATION*/

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id)
    {
        boolean resp = studentService.delete(id);
        if(!resp) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Student Record Deleted");
    }


    /**SOFT DELETE*/

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> softDelete(@RequestParam Long id)
    {
        boolean deleted = studentService.softDelete(id);
        if(!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Student Record Soft Deleted");
    }
}
