package com.endeavour;

import com.endeavour.model.Student;
import com.endeavour.repository.StudentRepository;

public class Main
{
    public static void main(String[] args)
    {
        StudentRepository studentRepository = new StudentRepository();
        //studentRepository.createUser(new Student("Anny", "anny@gmail.com", 24));
        //studentRepository.updateUser(new Student("Anny", "anny@gmail.com", 24), 3);
        //studentRepository.deleteUser(1);
        studentRepository.getUserById(3);
    }
}