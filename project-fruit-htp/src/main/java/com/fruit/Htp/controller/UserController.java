package com.fruit.Htp.controller;

import com.fruit.Htp.model.User;
import com.fruit.Htp.repository.UserRepository;
import com.fruit.Htp.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    @Autowired
    private UserSerivce userSerivce;

    @GetMapping("/api/users/profile")
    public User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {

        User user = userSerivce.findUserByJwt(jwt);
        return user;
    }


}


