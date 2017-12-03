package com.che.cheapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.che.cheapi.model.Candidate;
import com.che.cheapi.model.Role;
import com.che.cheapi.service.CandidateService;
import com.che.cheapi.service.UserService;
import com.che.cheapi.util.Constants;

@RestController
@RequestMapping(Constants.API_URL+Constants.API_REGISTER_CANDIDATE)
public class CandidateController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final CandidateService candidateService;
    
    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @RequestMapping(method=RequestMethod.POST)
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
}
