package com.company.usertask.service.impl;

import com.company.usertask.dto.request.UserRequestDTO;
import com.company.usertask.exception.UserNotFoundException;
import com.company.usertask.mapper.AccountMapper;
import com.company.usertask.domain.Account;
import com.company.usertask.domain.User;
import com.company.usertask.repository.UserRepository;
import com.company.usertask.dto.response.UserResponseDTO;
import com.company.usertask.mapper.UserMapper;
import com.company.usertask.service.IUserService;
import com.company.usertask.util.Validation;
import com.company.usertask.util.result.DataResult;
import com.company.usertask.util.result.Result;
import com.company.usertask.util.result.SuccessDataResult;
import com.company.usertask.util.result.SuccessResult;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService implements IUserService {

    final AccountService accountService;

    final UserRepository userRepository;

    final UserMapper userMapper;

    final AccountMapper accountMapper;

    @Cacheable(cacheNames = {"users"},key = "0")
    @Override
    public DataResult<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users =  userRepository.findAll().stream()
                .map(userMapper::userToUserResponseDTO)
                .toList();
        return new SuccessDataResult<>(users,"All users are listed.");
    }

    @Cacheable(cacheNames = {"users"}, key = "#id")
    @Override
    public DataResult<UserResponseDTO> getUserById(Long id) {
        UserResponseDTO userResponseDTO =  userMapper.userToUserResponseDTO(getUser(id));
        return new SuccessDataResult<>(userResponseDTO);
    }

    @CacheEvict(cacheNames = {"users"} , key = "0")
    @Override
    public Result addUser(UserRequestDTO userRequestDTO) {
        Validation.validateUserRequest(userRequestDTO);

        Set<Account> accounts = userRequestDTO.getAccounts().stream()
                        .map(accountMapper::accountRequestDTOtoAccount)
                                .collect(Collectors.toSet());
        accounts.forEach(Validation::validateAccountRequest);

        User user = userRepository.save(userMapper.userRequestDTOtoUser(userRequestDTO));

        accounts.stream().peek(account -> account.setUser(user)).collect(Collectors.toSet());
        accountService.saveAccountsAll(accounts);
        user.setAccounts(accounts);

        return new SuccessResult("new user added.");
    }

    @CachePut(cacheNames = {"users"},key = "#userId")
    @Override
    public Result updateUser(Long userId,UserRequestDTO userRequestDTO) {
        User user = getUser(userId);
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());

        Validation.validateUserRequest(userRequestDTO);

        user = userRepository.save(user);

        return new SuccessResult(String.format("User %s %s updated",user.getFirstName(),user.getLastName()));
    }

    @CacheEvict(cacheNames = {"users"},key = "#userId")
    @Override
    public Result delete(Long userId) {
        User user = getUser(userId);
        userRepository.delete(user);
        return new SuccessResult(String.format("User %s deleted",user.getFirstName()));
    }

    private User getUser(Long id){
        return userRepository.findById(id).orElseThrow
                (() -> new UserNotFoundException(String.format("User %d not found",id)));
    }
    protected User getUserByAccountId(Long id){
        return userRepository.getUserByAccountId(id);
    }
}
