package com.company.usertask.service;

import com.company.usertask.util.result.Result;

import java.math.BigDecimal;

public interface IPaymentService {

    Result payOtherToAccount(Long producerAccountId, String accountNumber, BigDecimal money);

    Result pullMoney(Long id, BigDecimal money);

    Result pushMoney(String accountNumber,BigDecimal money);

}
