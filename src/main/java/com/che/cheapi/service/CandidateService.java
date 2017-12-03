package com.che.cheapi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.che.cheapi.model.Candidate;


public interface CandidateService {

	Candidate findByUsername(String name);

	Candidate findByEmail(String email);

    Page<Candidate> findAllByPage(Pageable pageable);

    Candidate findOne(long id);

    void delete(long id);

    List<Candidate> findAll();

    void saveOrUpdate(Candidate candidate);

    Long count();
    
}
