package com.endeavour.crud3.dto;

public class UpdateRequestDTO
{
    //taking all fields of student here for update, but we can restrict how many fields must be allowed update or not, that's the real use of DTOs, obviously.
    //DTOs can be applied to all CRUD operations
    private String name;
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
