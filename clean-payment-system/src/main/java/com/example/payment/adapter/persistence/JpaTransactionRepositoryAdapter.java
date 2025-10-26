package com.example.payment.adapter.persistence;

import com.example.payment.adapter.persistence.entity.TransactionEntity;
import com.example.payment.adapter.persistence.jparepo.TransactionJpaRepository;
import com.example.payment.domain.model.Transaction;
import com.example.payment.domain.repository.TransactionRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaTransactionRepositoryAdapter implements TransactionRepository {

    private final TransactionJpaRepository repo;

    public JpaTransactionRepositoryAdapter(TransactionJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Transaction save(Transaction tx) {
        TransactionEntity e = new TransactionEntity();
        e.setFromAccount(tx.getFromAccount());
        e.setToAccount(tx.getToAccount());
        e.setAmount(tx.getAmount());
        e.setType(tx.getType());
        e.setTimestamp(tx.getTimestamp());
        TransactionEntity saved = repo.save(e);
        Transaction out = new Transaction();
        out.setId(saved.getId());
        out.setFromAccount(saved.getFromAccount());
        out.setToAccount(saved.getToAccount());
        out.setAmount(saved.getAmount());
        out.setType(saved.getType());
        out.setTimestamp(saved.getTimestamp());
        return out;
    }
}
