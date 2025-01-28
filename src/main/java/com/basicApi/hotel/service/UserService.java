package com.basicApi.hotel.service;

import com.basicApi.hotel.dto.UserRequestDto;
import com.basicApi.hotel.entity.User;
import com.basicApi.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void register(UserRequestDto userRequestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = passwordEncoder.encode(userRequestDto.getPassword());
        User user = new User();
        user.setUserName(userRequestDto.getUserName());
        user.setPassword(pass);
        userRepository.save(user);
    }
}
