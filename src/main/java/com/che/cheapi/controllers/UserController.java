package com.che.cheapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.che.cheapi.model.User;
import com.che.cheapi.service.UserService;
import com.che.cheapi.util.Constants;

@RestController
@RequestMapping(Constants.API_URL+Constants.URL_USERS)
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/info")
    @ResponseBody
    public User getCurrentUser(@AuthenticationPrincipal User userPrincipal){
    	LOGGER.info("Start getById with AuthenticationPrincipal: {}", userPrincipal);
    	return userPrincipal;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Page<User> getAllUsers(@AuthenticationPrincipal User user,Pageable pageable){
    	
    	LOGGER.info("Start getUsers");
    	Page<User> users = userService.findAllByPage(pageable);
    	return users;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ResponseBody
    public User getUserById(@AuthenticationPrincipal User userPrincipal,@PathVariable("id") Long id){
    	User user = userService.findOne(id);
    	return user;
    }

}
