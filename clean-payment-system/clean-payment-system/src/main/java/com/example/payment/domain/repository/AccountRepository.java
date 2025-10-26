package com.example.payment.domain.repository;

import com.example.payment.domain.model.Account;

public interface AccountRepository {
    Account findByAccountNumber(String accountNumber);
    Account save(Account account);
}
