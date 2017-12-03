package com.che.cheapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.che.cheapi.model.Candidate;

@Repository
@Transactional
public interface CandidateDAO extends JpaRepository<Candidate,Long>{
	
	Candidate findByEmail(String email);

    Candidate findByName(String name);

}
