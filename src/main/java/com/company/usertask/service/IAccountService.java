package com.company.usertask.service;

import com.company.usertask.dto.request.AccountRequestDTO;
import com.company.usertask.dto.response.AccountResponseDTO;
import com.company.usertask.util.result.DataResult;
import com.company.usertask.util.result.Result;

import java.util.List;

public interface IAccountService {

    DataResult<List<AccountResponseDTO>> getAllAccounts();

    DataResult<AccountResponseDTO> getAccountById(Long id);

    Result addAccount(AccountRequestDTO accountRequestDTO);

    Result updateAccount(Long id,AccountRequestDTO accountRequestDTO);

    Result deleteAccount(Long id);

    Result isBlock(Long id);

    Result isActive(Long id);

    Result changePassword(Long id, String newPassword);
}
