package com.example.payment.adapter.controller;

import com.example.payment.usecase.TransferMoneyUseCase;
import com.example.payment.usecase.dto.TransferRequest;
import com.example.payment.usecase.dto.TransferResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final TransferMoneyUseCase transferMoneyUseCase;

    public PaymentController(TransferMoneyUseCase transferMoneyUseCase) {
        this.transferMoneyUseCase = transferMoneyUseCase;
    }

    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest request) {
        return transferMoneyUseCase.transfer(request);
    }
}
