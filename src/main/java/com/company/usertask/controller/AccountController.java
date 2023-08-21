package com.company.usertask.controller;

import com.company.usertask.dto.request.AccountRequestDTO;
import com.company.usertask.dto.response.AccountResponseDTO;
import com.company.usertask.service.IAccountService;
import com.company.usertask.util.result.DataResult;
import com.company.usertask.util.result.Result;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/accounts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountController {

    final IAccountService accountService;

    @GetMapping
    public DataResult<List<AccountResponseDTO>> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "/{id}")
    public DataResult<AccountResponseDTO> getAccountById(@PathVariable  Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping(path = "/")
    public Result addAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.addAccount(accountRequestDTO);
    }

    @PutMapping(path = "/{id}")
    public Result updateAccount(@PathVariable Long id,
                                @RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.updateAccount(id,accountRequestDTO);
    }

    @DeleteMapping(path = "/{id}")
    public Result deleteAccount(@PathVariable Long id){
        return accountService.deleteAccount(id);
    }

    @PatchMapping(path = "/{id}")
    public Result isBlock(@PathVariable Long id){
        return accountService.isBlock(id);
    }

    @PatchMapping(path = "/{id}/password")
    public Result changePassword(@PathVariable Long id,
                                  @RequestParam String newPassword){
        return accountService.changePassword(id,newPassword);
    }


}
