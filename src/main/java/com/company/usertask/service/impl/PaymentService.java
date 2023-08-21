package com.company.usertask.service.impl;

import com.company.usertask.domain.Account;
import com.company.usertask.exception.PaymentException;
import com.company.usertask.service.IPaymentService;
import com.company.usertask.util.Validation;
import com.company.usertask.util.result.Result;
import com.company.usertask.util.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

    final AccountService accountService;


    @Override
    public Result payOtherToAccount(Long producerAccountId, String accountNumber, BigDecimal money) {
        Validation.validateAccountNumber(accountNumber);
        Validation.isNull(money);
        pullMoney(producerAccountId,money);
        pushMoney(accountNumber,money);

        return new SuccessResult("payment was made");
    }

    @Override
    public Result pullMoney(Long id, BigDecimal money) {
        Account account = accountService.getAccount(id);

        if(account.getMoney().compareTo(money) < 0){
            throw new PaymentException("You don't have enough balance!!!");
        }
        account.setMoney(account.getMoney().subtract(money));

        return new SuccessResult(String.format("Money pulled from %s account",account.getUsername()));
    }

    @Override
    public Result pushMoney(String accountNumber, BigDecimal money) {
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        account.setMoney(account.getMoney().add(money) );
        accountService.addOrUpdateAccount(account);

        return new SuccessResult(String.format("Money pushed to %s account",account.getUsername()));
    }
}
