package com.fruit.Htp.service;

import com.fruit.Htp.model.User;
import org.springframework.stereotype.Service;


public interface UserSerivce {

    public User findUserById(Long userId) throws Exception;

    public User findUserByJwt(String jwt) throws Exception;
}
