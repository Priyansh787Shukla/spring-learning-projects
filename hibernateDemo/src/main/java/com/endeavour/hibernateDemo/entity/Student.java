package com.endeavour.hibernateDemo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Student_Records")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_roll_no.")
    private Long id;

    @Column(name = "student_names", nullable = false, length = 100)
    private String name;

    @Column(name = "student_emails", nullable = false, unique = true, length = 200)
    private String email;

    @Column(name = "student_age")
    private int age;

    @Embedded
    private Address address;

    public Student() {
    }

    public Student(Long id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
