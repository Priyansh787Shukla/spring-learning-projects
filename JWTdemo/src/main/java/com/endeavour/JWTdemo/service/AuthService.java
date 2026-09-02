package com.endeavour.JWTdemo.service;

import com.endeavour.JWTdemo.dto.UserRegisterRequestDto;
import com.endeavour.JWTdemo.dto.UserRegisterResponseDto;
import com.endeavour.JWTdemo.entity.Role;
import com.endeavour.JWTdemo.entity.User;
import com.endeavour.JWTdemo.repository.RoleRepository;
import com.endeavour.JWTdemo.repository.UserRepository;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegisterResponseDto register(UserRegisterRequestDto registerRequestDto)
    {
        User user = new User();
        user.setUsername(registerRequestDto.getUsername());

        String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());

        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Role role = roleRepository.findByName("ROLE_USER").get();

        user.getRoles().add(role);

        userRepository.save(user);

        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();

        responseDto.setUsername(user.getUsername());
        responseDto.setMessage("User saved Successfully");

        return responseDto;
    }
}