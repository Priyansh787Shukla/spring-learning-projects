package com.endeavour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class User
{
    String name;
    int age;

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void show()
    {
        System.out.println("Shopper's Name: "+name+", Age: "+age);
    }
}
