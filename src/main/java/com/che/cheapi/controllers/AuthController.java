package com.che.cheapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.che.cheapi.model.Role;
import com.che.cheapi.model.User;
import com.che.cheapi.service.AuthService;
import com.che.cheapi.service.RoleService;
import com.che.cheapi.util.Constants;

@RestController
@RequestMapping(Constants.API_URL+Constants.URL_AUTH)
public class AuthController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;
    private final RoleService roleService;

    @Autowired
    public AuthController(AuthService authService, RoleService roleService) {
        this.authService = authService;
        this.roleService = roleService;
    }

	@PostMapping("/register")
	@ResponseBody
	public String register(User user){
		try{
			LOGGER.info("Start register user: {}", user);
			
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	        List<Role> roles = new ArrayList<>();
	        roles.add(roleService.findRole(1));
	        user.setRoles(roles);
	        authService.register(user);
		}catch(Exception e){
			e.printStackTrace();
			return "Registeration Failure";
		}
		return "Successful Registeration";
	}
}
