package com.endeavour.transactions.service;

import com.endeavour.transactions.entity.Account;
import com.endeavour.transactions.entity.TransferRecord;
import com.endeavour.transactions.repository.AccountRepository;
import com.endeavour.transactions.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService
{
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;
    public TransferService(AccountRepository accountRepository,  TransferRepository transferRepository)
    {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount)
    {
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(()->new RuntimeException("User Not Found"));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(()->new RuntimeException("User Not Found"));
        fromAccount.debitAmount(amount);
        toAccount.creditAmount(amount);
        transferRepository.save(new TransferRecord(fromAccountId, toAccountId, amount, LocalDate.now()));
    }
}
