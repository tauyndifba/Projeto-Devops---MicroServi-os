package com.ifba.tauynd.projeto_devops_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import com.ifba.tauynd.projeto_devops_app.DTOs.UserDTO;

import java.util.List;

@Service
public class UserServiceClient {

    private static final String BASE_URL = "http://persistent:8080/users"; 

    @Autowired
    private RestTemplate restTemplate;

    public UserDTO createUser(UserDTO userDTO) {
        ResponseEntity<UserDTO> response = restTemplate.postForEntity(BASE_URL, userDTO, UserDTO.class);
        return response.getBody();
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<UserDTO> getAllUsers() {
        ResponseEntity<List> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, null, List.class);
        return response.getBody();
    }

    public UserDTO getUserById(Integer id) {
        String url = BASE_URL + "/" + id;
        return restTemplate.getForObject(url, UserDTO.class);
    }

    public void deleteUser(Integer id) {
        String url = BASE_URL + "/" + id;
        restTemplate.delete(url);
    }
}
