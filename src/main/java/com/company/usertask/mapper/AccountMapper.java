package com.company.usertask.mapper;

import com.company.usertask.domain.Account;
import com.company.usertask.dto.request.AccountRequestDTO;
import com.company.usertask.dto.response.AccountResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account accountRequestDTOtoAccount(AccountRequestDTO accountRequestDTO){
        return Account.builder()
                .accountNumber(accountRequestDTO.getAccountNumber())
                .email(accountRequestDTO.getEmail())
                .username(accountRequestDTO.getUsername())
                .password(accountRequestDTO.getPassword())
                .isActive(Boolean.TRUE)
                .money(accountRequestDTO.getMoney())
                .build();
    }

    public AccountResponseDTO accountToAccountResponseDTO(Account account){
        return AccountResponseDTO.builder()
                .accountId(account.getAccountId())
                .accountNumber(account.getAccountNumber())
                .email(account.getEmail())
                .username(account.getUsername())
                .password(account.getPassword())
                .money(account.getMoney())
                .build();
    }

}
