package com.haris.belajarspringrestfulapi.service;

import com.haris.belajarspringrestfulapi.entity.User;
import com.haris.belajarspringrestfulapi.model.LoginUserRequest;
import com.haris.belajarspringrestfulapi.model.TokenResponse;
import com.haris.belajarspringrestfulapi.repository.UserRepository;
import com.haris.belajarspringrestfulapi.security.BCrypt;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public TokenResponse login(LoginUserRequest request) {
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "username username or password wrong"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            //sukses
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());
            userRepository.save(user);

            return TokenResponse.builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();
        } else {
            //gagal
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "password is wrong");
        }
    };

    private Long next30Days() {
        return System.currentTimeMillis() + (1000 * 16 * 24 * 30);
    }

    @Transactional
    public void logout(User user) {
        user.setTokenExpiredAt(null);
        user.setToken(null);

        userRepository.save(user);
    }

}
