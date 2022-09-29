package com.example.library.Service;

import com.example.library.Repository.UserRepository;
import com.example.library.Model.User;
import com.example.library.dto.Request.UserRequest;
import com.example.library.dto.mapper.ObjectMapperUtils;
import com.example.library.dto.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getUser() {
        List<User> users = userRepository.findAll();
        return ObjectMapperUtils.mapAll(users , UserDTO.class);
    }

    public void addUser(UserRequest userRequest) {
        User user = ObjectMapperUtils.map(userRequest , User.class);
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteAllById(Collections.singleton(userId));
    }

    public void updateUser(UserRequest userRequest) {
        User user = ObjectMapperUtils.map(userRequest , User.class);
        userRepository.save(user);
    }
}
