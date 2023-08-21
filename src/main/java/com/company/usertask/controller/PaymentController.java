package com.company.usertask.controller;

import com.company.usertask.service.IPaymentService;
import com.company.usertask.util.result.Result;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/payments")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentController {

    final IPaymentService paymentService;
    @PatchMapping(path = "/{producerAccountId}")
    public Result pay(@PathVariable Long producerAccountId,
                      @RequestParam String accountNumber,
                      @RequestParam BigDecimal money){
        return paymentService.payOtherToAccount(producerAccountId,accountNumber,money);
    }

    @PatchMapping(path = "/{id}/pull")
    public Result pullMoney(@PathVariable Long id,
                             @RequestParam BigDecimal money){
        return paymentService.pullMoney(id,money);
    }

    @PatchMapping(path = "/push")
    public Result pushMoney(@RequestParam String accountNumber,
                             @RequestParam BigDecimal money){
        return paymentService.pushMoney(accountNumber,money);
    }
}
