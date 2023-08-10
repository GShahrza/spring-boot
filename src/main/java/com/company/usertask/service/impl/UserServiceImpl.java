package com.company.usertask.service.impl;

import com.company.usertask.dao.repository.UserRepository;
import com.company.usertask.dto.response.AccountResponseDTO;
import com.company.usertask.dto.response.UserResponseDTO;
import com.company.usertask.mapper.UserMapper;
import com.company.usertask.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                 .stream()
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
        return null;
    }

    @Override
    public UserResponseDTO getByUsername(String username) {
        return null;
    }
}
