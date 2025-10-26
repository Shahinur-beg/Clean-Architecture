package com.example.payment.framework.config;

import com.example.payment.adapter.persistence.JpaAccountRepositoryAdapter;
import com.example.payment.adapter.persistence.JpaTransactionRepositoryAdapter;
import com.example.payment.usecase.TransferMoneyUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public TransferMoneyUseCase transferMoneyUseCase(JpaAccountRepositoryAdapter accountRepo, JpaTransactionRepositoryAdapter txRepo) {
        return new TransferMoneyUseCase(accountRepo, txRepo);
    }
}
