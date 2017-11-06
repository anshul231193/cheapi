package com.che.cheapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.che.cheapi.model.User;

public interface UserService {
	
	User findByUsername(String name);

    User findByEmail(String email);

    Page<User> findAllByPage(Pageable pageable);

    User findOne(long id);

    void delete(long id);

    List<User> findAll();

    void saveOrUpdate(User user);

    Long count();

}
