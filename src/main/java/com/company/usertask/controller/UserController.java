package com.company.usertask.controller;

import com.company.usertask.dto.request.UserRequestDTO;
import com.company.usertask.dto.response.UserResponseDTO;
import com.company.usertask.service.IUserService;
import com.company.usertask.util.result.DataResult;
import com.company.usertask.util.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public DataResult<List<UserResponseDTO>> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public DataResult<UserResponseDTO> getUserById(@PathVariable Long id){
        return  userService.getUserById(id);
    }

    @PostMapping(path = "/")
    public Result addUser(@RequestBody UserRequestDTO userRequestDTO){
        return userService.addUser(userRequestDTO);
    }

    @PutMapping(path = "/{id}")
    public Result updateUser(@PathVariable Long id,@RequestBody UserRequestDTO userRequestDTO){
        return userService.updateUser(id,userRequestDTO);
    }
    @DeleteMapping(path = "/{id}")
    public Result deleteUser(@PathVariable Long id){
        return userService.delete(id);
    }

}
