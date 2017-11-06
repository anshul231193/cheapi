package com.che.cheapi.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.che.cheapi.model.User;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User,Long>{
	
	User findByEmail(String email);

    User findByUsername(String username);
    
}
