package com.endeavour.transactions.service;

import com.endeavour.transactions.entity.Account;
import com.endeavour.transactions.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    private AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account)
    {
        accountRepository.save(account);
    }
}
