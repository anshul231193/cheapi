package com.che.cheapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.che.cheapi.model.Candidate;
import com.che.cheapi.model.Role;
import com.che.cheapi.model.User;
import com.che.cheapi.service.CandidateService;
import com.che.cheapi.service.UserService;
import com.che.cheapi.util.Constants;

@RestController
@RequestMapping(Constants.API_URL)
public class CandidateController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final CandidateService candidateService;
    
    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @RequestMapping(value=Constants.API_REGISTER_CANDIDATE,method=RequestMethod.POST)
    @ResponseBody
    public String registerCandidate(Candidate candidate){
    	try{
			LOGGER.info("Start register user: {}", candidate);
			
			candidateService.saveOrUpdate(candidate);
		}catch(Exception e){
			e.printStackTrace();
			return "Registeration Failure";
		}
		return "Successful Registeration";
    }
    
    @RequestMapping(value=Constants.API_CANDIDATES,method=RequestMethod.GET)
    @ResponseBody
    public List<Candidate> getAllCandidates(){
    	
    	LOGGER.info("Start getCandidates");
    	List<Candidate> candidates = candidateService.findAll();
    	return candidates;
    }
    
    @RequestMapping(value=Constants.API_CANDIDATES+"/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Candidate getCandidateById(@PathVariable("id")Long id){
    	return candidateService.findOne(id);
    }
}
