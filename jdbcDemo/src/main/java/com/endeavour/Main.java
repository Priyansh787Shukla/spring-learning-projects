package com.endeavour;

import com.endeavour.repository.StudentRepository;

public class Main
{
    public static void main(String[] args)
    {
        StudentRepository studentRepository = new StudentRepository();
        //studentRepository.createUser();
        //studentRepository.updateUser();
        //studentRepository.deleteUser();
        studentRepository.getUserById(1);
    }
}