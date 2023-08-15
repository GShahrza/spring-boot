package com.company.usertask.service.impl;

import com.company.usertask.dao.entity.Account;
import com.company.usertask.dao.entity.User;
import com.company.usertask.dao.repository.AccountRepository;
import com.company.usertask.dao.repository.UserRepository;
import com.company.usertask.dto.response.AccountResponseDTO;
import com.company.usertask.dto.response.UserResponseDTO;
import com.company.usertask.mapper.UserMapper;
import com.company.usertask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AccountRepository accountRepository;

    private final UserMapper userMapper;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserResponseDTO)
                .collect(Collectors.toList());
//
//        return userRepository.findAll()
//                .stream()
//                   .map(user ->
//                        UserResponseDTO
//                            .builder()
//                                .userId(user.getUserId())
//                                .firstName(user.getFirstName())
//                                .lastName(user.getLastName())
//                                .accounts(user.getAccounts()
//                                        .stream()
//                                            .map(account ->
//                                                AccountResponseDTO
//                                                   .builder()
//                                                        .accountId(account.getAccountId())
//                                                        .username(account.getUsername())
//                                                        .email(account.getEmail())
//                                                        .password(account.getPassword())
//                                                        .accountNumber(account.getAccountNumber())
//                                                        .money(account.getMoney())
//                                                   .build())
//                                        .collect(Collectors.toSet()))
//                            .build()
//                        )
//                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getByIdUser(Long id) {
        return userMapper.userToUserResponseDTO(userRepository.findById(id).orElse(null));
    }

    @Override
    public UserResponseDTO getByUsername(String username) {
        return null;
    }
}
