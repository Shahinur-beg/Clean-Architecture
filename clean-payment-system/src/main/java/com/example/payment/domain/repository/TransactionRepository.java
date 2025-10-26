package com.example.payment.domain.repository;

import com.example.payment.domain.model.Transaction;

public interface TransactionRepository {
    Transaction save(Transaction tx);
}
