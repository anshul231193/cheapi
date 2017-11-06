package com.che.cheapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.che.cheapi.model.User;

@Repository
@Transactional
public interface AuthDAO extends CrudRepository<User, Long>{

}
