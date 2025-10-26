package com.example.payment.adapter.persistence.jparepo;

import com.example.payment.adapter.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, Long> {
}
