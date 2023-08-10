package com.company.usertask.mapper;

import com.company.usertask.dao.entity.User;
import com.company.usertask.dto.request.UserRequestDTO;
import com.company.usertask.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    User userRequestDTOtoUser(UserRequestDTO userRequestDTO);

    UserResponseDTO userToUserResponseDTO(User user);
}
