package com.ifba.tauynd.projeto_devops_persistent.service;

import com.ifba.tauynd.projeto_devops_persistent.models.User;
import com.ifba.tauynd.projeto_devops_persistent.DTOs.UserDTO;
import com.ifba.tauynd.projeto_devops_persistent.db.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDatabase userDatabase;

    public UserDTO createOrUpdateUser(UserDTO userDTO) {
        User user = new User(userDTO.getName(), userDTO.getEmail());
        user.setId(userDTO.getId());
        user = userDatabase.save(user);
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }


    public List<UserDTO> getAllUsers() {
        return userDatabase.findAll().stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }


    public Optional<UserDTO> getUserById(Integer id) {
        return userDatabase.findById(id)
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()));
    }


    public void deleteUser(Integer id) {
        userDatabase.deleteById(id);
    }
}

