package com.example.payment.domain.model;

import java.math.BigDecimal;

public class Account {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    public Account() {}

    public Account(Long id, String accountNumber, BigDecimal balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void debit(java.math.BigDecimal amount) {
        if (balance.compareTo(amount) < 0) throw new IllegalStateException("Insufficient balance");
        this.balance = this.balance.subtract(amount);
    }

    public void credit(java.math.BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
