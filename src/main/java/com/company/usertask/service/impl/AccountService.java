package com.company.usertask.service.impl;

import com.company.usertask.dto.request.AccountCriteria;
import com.company.usertask.dto.request.AccountRequestDTO;
import com.company.usertask.dto.request.PageCriteria;
import com.company.usertask.dto.response.AccountResponseDTO;
import com.company.usertask.exception.AccountNotFoundException;
import com.company.usertask.mapper.AccountMapper;
import com.company.usertask.domain.Account;
import com.company.usertask.repository.AccountRepository;
import com.company.usertask.service.IAccountService;
import com.company.usertask.util.Validation;
import com.company.usertask.util.result.DataResult;
import com.company.usertask.util.result.Result;
import com.company.usertask.util.result.SuccessDataResult;
import com.company.usertask.util.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Override
    public DataResult<List<AccountResponseDTO>> getAllAccounts(PageCriteria pageCriteria, AccountCriteria accountCriteria) {

        int pageNumber = pageCriteria.getPage() == null ? 0 : pageCriteria.getPage();
        int count = pageCriteria.getCount() == null ? 10 : pageCriteria.getCount();

        List<AccountResponseDTO> accounts =  accountRepository.findAll(PageRequest.of(pageNumber, count, Sort.by("id").descending())).stream()
                .map(accountMapper::accountToAccountResponseDTO)
                .toList();
        return new SuccessDataResult<>(accounts,"all accounts are listed.");
    }

    @Override
    public DataResult<AccountResponseDTO> getAccountById(Long id) {
        return new SuccessDataResult<>(accountMapper.accountToAccountResponseDTO(getAccount(id)));
    }

    @Override
    public Result addAccount(AccountRequestDTO accountRequestDTO) {
        addOrUpdateAccount(accountMapper.accountRequestDTOtoAccount(accountRequestDTO));
        return new SuccessResult(String.format("new account %s added",accountRequestDTO.getUsername()));
    }

    @Override
    public Result updateAccount(Long id,AccountRequestDTO accountRequestDTO) {
        Account account = getAccount(id);
        account.setUsername(accountRequestDTO.getUsername());
        account.setEmail(accountRequestDTO.getEmail());

        addOrUpdateAccount(account);

        return new SuccessResult(String.format("Account %s updated",accountRequestDTO.getUsername()));
    }

    @Override
    public Result deleteAccount(Long id) {
        Account account = getAccount(id);
        accountRepository.delete(account);
        return new SuccessResult(String.format("Account %s deleted",account.getUsername()));
    }

    @Override
    public Result isBlock(Long id) {
        Account account = getAccount(id);
        account.setIsActive(false);
        account = accountRepository.save(account);

        return new SuccessResult(String.format("Account %s blocked",account.getUsername()));
    }

    @Override
    public Result isActive(Long id) {
        Account account = getAccount(id);
        account.setIsActive(true);
        account = addOrUpdateAccount(account);

        return new SuccessResult(String.format("Account %s actived.",account.getUsername()));
    }

    @Override
    public Result changePassword(Long id, String newPassword) {
        Account account = getAccount(id);
        account.setPassword(newPassword);

        addOrUpdateAccount(account);
        return new SuccessResult(String.format("account %s password changed",account.getUsername()));
    }

    Account getAccountByAccountNumber(String accountNumber){
        Validation.isNull(accountNumber);
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow
                        (() -> new AccountNotFoundException(String.format("Account %s not found",accountNumber)));
    }

    protected void saveAccountsAll(Set<Account> accounts){
        accounts.forEach(Validation::validateAccountRequest);
        accountRepository.saveAll(accounts);
    }

    protected Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow
                        (() -> new AccountNotFoundException(String.format("Account %d not found",id)));
    }
    protected Account addOrUpdateAccount(Account account){
        Validation.validateAccountRequest(account);
        return accountRepository.save(account);
    }
}
