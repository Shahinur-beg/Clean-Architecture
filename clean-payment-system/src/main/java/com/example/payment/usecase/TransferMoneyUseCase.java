package com.example.payment.usecase;

import com.example.payment.domain.model.Account;
import com.example.payment.domain.model.Transaction;
import com.example.payment.domain.repository.AccountRepository;
import com.example.payment.domain.repository.TransactionRepository;
import com.example.payment.usecase.dto.TransferRequest;
import com.example.payment.usecase.dto.TransferResponse;

public class TransferMoneyUseCase {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransferMoneyUseCase(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public TransferResponse transfer(TransferRequest request) {
        Account from = accountRepository.findByAccountNumber(request.getFromAccount());
        Account to = accountRepository.findByAccountNumber(request.getToAccount());

        if (from == null || to == null) {
            return new TransferResponse("FAILURE", "Account not found");
        }

        from.debit(request.getAmount());
        to.credit(request.getAmount());

        accountRepository.save(from);
        accountRepository.save(to);

        Transaction tx = new Transaction(from.getAccountNumber(), to.getAccountNumber(), request.getAmount(), "TRANSFER");
        transactionRepository.save(tx);

        return new TransferResponse("SUCCESS", "Transfer completed successfully");
    }
}
