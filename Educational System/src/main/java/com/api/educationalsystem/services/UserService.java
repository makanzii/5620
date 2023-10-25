package com.api.educationalsystem.services;

import com.api.educationalsystem.mapper.UserMapper;
import com.api.educationalsystem.models.LoginVO;
import com.api.educationalsystem.models.User;
import com.api.educationalsystem.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    UserMapper userMapper;

    public LoginVO login(User user) {

        var userInDb = userMapper.getByEmail(user.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email"));
        if (user.getPassword().equals(userInDb.getPassword())) {
            String token = JwtUtil.generateToken(user);
            return LoginVO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .nickName(user.getNickName())
                    .token(token)
                    .build();
        } else
            throw new RuntimeException("Authentication Failed");
    }
}
