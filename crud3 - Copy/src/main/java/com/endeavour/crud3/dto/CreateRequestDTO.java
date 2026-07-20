package com.endeavour.crud3.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateRequestDTO
{
    //putting validation annotations on name and age for CREATE and UPDATE requests

    @NotBlank(message = "Name cannot be blank!")
    @Size(min = 2, max = 55, message = "Name must be 2 to 55 character long!")
    private String name;

    @Min(value = 18, message = "Age must be at least 18!")

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
