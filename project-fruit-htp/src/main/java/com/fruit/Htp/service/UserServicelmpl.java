package com.fruit.Htp.service;

import com.fruit.Htp.config.JwtProvider;
import com.fruit.Htp.model.User;
import com.fruit.Htp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicelmpl implements UserSerivce {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new Exception("User not found with id" + userId);
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        if(email==null) {
            throw new Exception("Provide valid jwt token...");
        }
        User user = userRepository.findByEmail(email);
        if(user==null) {
            throw new Exception("User not fount with email "+ email);
        }
        return user;
    }
}
