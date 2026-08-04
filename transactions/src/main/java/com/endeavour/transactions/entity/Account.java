package com.endeavour.transactions.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal balance;

    public void debitAmount(BigDecimal amount)
    {
        if(amount==null || amount.signum()<=0) throw new IllegalArgumentException("Amount cannot be negative");
        if(balance.compareTo(amount)<0) throw new RuntimeException("Insufficient balance");
        this.balance = this.balance.subtract(amount);
    }

    public void creditAmount(BigDecimal amount)
    {
        if(amount==null || amount.signum()<=0) throw new IllegalArgumentException("Amount cannot be negative");
        this.balance = this.balance.add(amount);
    }
}
