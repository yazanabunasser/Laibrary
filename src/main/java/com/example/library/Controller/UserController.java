package com.example.library.Controller;

import com.example.library.Service.UserService;
import com.example.library.Model.User;
import com.example.library.dto.Request.UserRequest;
import com.example.library.dto.model.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUser(){
        return userService.getUser();
    }

    @PostMapping
    public void addUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
    }

    @PutMapping
    public void updateUser(@RequestBody UserRequest userRequest){
        userService.updateUser(userRequest);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }



}
