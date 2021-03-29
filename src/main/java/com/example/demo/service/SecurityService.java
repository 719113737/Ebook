package com.example.demo.service;

import com.example.demo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {

    @Autowired
    UserInfoMapper user_mapper;

    public List<String> getRoleByUrl(String url) {
        return user_mapper.getRoleByUrl(url);
    }
}
