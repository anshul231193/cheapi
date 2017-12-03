package com.che.cheapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.che.cheapi.dao.CandidateDAO;
import com.che.cheapi.model.Candidate;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	private CandidateDAO candidateDao;
	
	@Override
	public Candidate findByUsername(String name) {
		// TODO Auto-generated method stub
		return candidateDao.findByName(name);
	}

	@Override
	public Candidate findByEmail(String email) {
		// TODO Auto-generated method stub
		return candidateDao.findByEmail(email);
	}

	@Override
	public Page<Candidate> findAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return candidateDao.findAll(pageable);
	}

	@Override
	public Candidate findOne(long id) {
		// TODO Auto-generated method stub
		return candidateDao.getOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		candidateDao.deleteById(id);
	}

	@Override
	public List<Candidate> findAll() {
		// TODO Auto-generated method stub
		return candidateDao.findAll();
	}

	@Override
	public void saveOrUpdate(Candidate candidate) {
		// TODO Auto-generated method stub
		candidateDao.save(candidate);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return candidateDao.count();
	}

}
