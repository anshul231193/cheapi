package com.che.cheapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.che.cheapi.dao.AuthDAO;
import com.che.cheapi.model.User;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDAO authRepository;

    @Override
    public void register(User user) {
        authRepository.save(user);
    }

}