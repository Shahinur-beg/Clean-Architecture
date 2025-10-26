package com.example.payment.framework.config;

import com.example.payment.adapter.persistence.entity.AccountEntity;
import com.example.payment.adapter.persistence.jparepo.AccountJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadSampleAccounts(AccountJpaRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                AccountEntity a = new AccountEntity();
                a.setAccountNumber("A-100");
                a.setBalance(BigDecimal.valueOf(1000.0));
                repo.save(a);

                AccountEntity b = new AccountEntity();
                b.setAccountNumber("B-200");
                b.setBalance(BigDecimal.valueOf(500.0));
                repo.save(b);
                System.out.println("Loaded sample accounts");
            }
        };
    }
}
