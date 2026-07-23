package com.endeavour;

import com.endeavour.repository.StudentRepository;

public class Main
{
    public static void main(String[] args)
    {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.createUser();
    }
}