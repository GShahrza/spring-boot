package com.company.usertask.service;

import com.company.usertask.dto.request.UserRequestDTO;
import com.company.usertask.dto.response.UserResponseDTO;
import com.company.usertask.util.result.DataResult;
import com.company.usertask.util.result.Result;

import java.util.List;

public interface IUserService {

    DataResult<List<UserResponseDTO>> getAllUsers();

    DataResult<UserResponseDTO> getUserById(Long id);

    Result addUser(UserRequestDTO userRequestDTO);

    Result updateUser(Long id, UserRequestDTO userRequestDTO);

    Result delete(Long id);

}
