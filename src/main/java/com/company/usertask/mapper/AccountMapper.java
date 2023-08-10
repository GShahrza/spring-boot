package com.company.usertask.mapper;

import com.company.usertask.dao.entity.Account;
import com.company.usertask.dao.entity.User;
import com.company.usertask.dto.request.AccountRequestDTO;
import com.company.usertask.dto.request.UserRequestDTO;
import com.company.usertask.dto.response.AccountResponseDTO;
import com.company.usertask.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AccountMapper {

    Account accountRequestDTOtoAccount(AccountRequestDTO accountRequestDTO);

    AccountResponseDTO accountToAccountResponseDTO(Account account);

}
