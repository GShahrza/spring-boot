package com.company.usertask.service;

import com.company.usertask.dao.entity.User;
import com.company.usertask.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getByIdUser(Long id);

    UserResponseDTO getByUsername(String username);
}
