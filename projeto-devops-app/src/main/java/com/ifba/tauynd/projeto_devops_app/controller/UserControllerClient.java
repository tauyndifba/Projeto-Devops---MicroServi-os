package com.ifba.tauynd.projeto_devops_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ifba.tauynd.projeto_devops_app.DTOs.UserDTO;
import com.ifba.tauynd.projeto_devops_app.service.UserServiceClient;

import java.util.List;

@RestController
@RequestMapping("/client-users")
public class UserControllerClient {

    @Autowired
    private UserServiceClient userServiceClient;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userServiceClient.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userServiceClient.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        return userServiceClient.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userServiceClient.deleteUser(id);
    }
}
