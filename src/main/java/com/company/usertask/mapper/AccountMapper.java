package com.company.usertask.mapper;

import com.company.usertask.dao.entity.Account;
import com.company.usertask.dao.entity.User;
import com.company.usertask.dto.request.AccountRequestDTO;
import com.company.usertask.dto.request.UserRequestDTO;
import com.company.usertask.dto.response.AccountResponseDTO;
import com.company.usertask.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account accountRequestDTOtoAccount(AccountRequestDTO accountRequestDTO){
        return Account.builder()

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
