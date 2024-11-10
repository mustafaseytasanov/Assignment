package com.example.assignment.service;

import com.example.assignment.entity.UserEntity;
import com.example.assignment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    public void saveUser(UserEntity userEntity) {
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }
}
