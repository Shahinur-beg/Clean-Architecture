package com.example.payment.adapter.persistence;

import com.example.payment.adapter.persistence.entity.AccountEntity;
import com.example.payment.adapter.persistence.jparepo.AccountJpaRepository;
import com.example.payment.domain.model.Account;
import com.example.payment.domain.repository.AccountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAccountRepositoryAdapter implements AccountRepository {

    private final AccountJpaRepository repo;

    public JpaAccountRepositoryAdapter(AccountJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return repo.findByAccountNumber(accountNumber)
                .map(e -> new Account(e.getId(), e.getAccountNumber(), e.getBalance()))
                .orElse(null);
    }

    @Override
    public Account save(Account account) {
        AccountEntity e = new AccountEntity();
        e.setId(account.getId());
        e.setAccountNumber(account.getAccountNumber());
        e.setBalance(account.getBalance());
        AccountEntity saved = repo.save(e);
        return new Account(saved.getId(), saved.getAccountNumber(), saved.getBalance());
    }
}
