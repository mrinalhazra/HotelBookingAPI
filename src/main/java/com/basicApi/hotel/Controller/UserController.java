package com.basicApi.hotel.Controller;

import com.basicApi.hotel.dto.UserRequestDto;
import com.basicApi.hotel.entity.User;
import com.basicApi.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getAllUser(){
       return userService.getAllUser();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void registerUser(@RequestBody UserRequestDto userRequestDto){
        userService.register(userRequestDto);
    }
}
