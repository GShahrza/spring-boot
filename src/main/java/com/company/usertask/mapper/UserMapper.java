package com.company.usertask.mapper;

import com.company.usertask.dao.entity.Account;
import com.company.usertask.dao.entity.User;
import com.company.usertask.dto.request.UserRequestDTO;
import com.company.usertask.dto.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final AccountMapper accountMapper;

    public User userRequestDTOtoUser(UserRequestDTO userRequestDTO){
        return User.builder()
                .build();
    }

    public UserResponseDTO userToUserResponseDTO(User user){
        return UserResponseDTO.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .accounts(user.getAccounts().stream()
                        .map(accountMapper::accountToAccountResponseDTO)
                        .collect(Collectors.toSet()))
                .build();
    }
}
