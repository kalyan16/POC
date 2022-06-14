package com.app.Controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.UserService;
import com.app.entity.User;
import com.app.repository.UserRepository;






@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService userServ;
	
	@PostMapping("/saveUser")
	public JSONObject saveUser(@RequestBody User user)
	{
	User save = userRepo.save(user);
	if(save!=null)
	{
	JSONObject response = userServ.userResponse("ok","Registration was succesfull" , "eyJhbGciOiJIUzI1NiIsInR5aB...");
	return response;
	}
	else
	{
	JSONObject response = userServ.userResponse("Not ok","Registration was failed" , "eyJhbGciOiJIUzI1NiIsInR5aC...");
	return response;
	}
	
}
}
