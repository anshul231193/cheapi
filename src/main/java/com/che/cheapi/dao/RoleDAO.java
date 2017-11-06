package com.che.cheapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.che.cheapi.model.Role;

@Repository
@Transactional
public interface RoleDAO extends JpaRepository<Role, Long>{

}
