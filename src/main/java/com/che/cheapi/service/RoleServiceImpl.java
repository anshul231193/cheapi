package com.che.cheapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.che.cheapi.dao.RoleDAO;
import com.che.cheapi.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleRepository;

    @Override
    public Role findRole(long id) {
        return roleRepository.getOne(id);
    }
}