package com.demo.banking.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User
{
    @Id
    private long accNo;

    private String name;
    private double balance;

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
