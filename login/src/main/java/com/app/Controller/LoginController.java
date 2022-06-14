package com.app.Controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.LoginDto.LoginDto;
import com.app.Service.UserService;
import com.app.entity.User;
import com.app.repository.UserRepository;



@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/getUsers")
	public List<User> getUsers()
	{
	List<User> users = userRepo.findAll();
	return users;
	}

	@PostMapping("/verifyLogin")
	public JSONObject verifylogin(@RequestBody LoginDto users)
	{
	String email = users.getEmail();
	String password = users.getPassword();
	User user = userRepo.findByEmail(email);
	if(user!=null) {
	if(user.getEmail().equals(email)&& user.getPassword().equals(password))
	{
	JSONObject response = userServ.userResponse("ok","Log In was succesfull" , "eyJhbGciOiJIUzI1NiIsInR5cC...");
	return response;
	}

	else
	{
	JSONObject response = userServ.userResponse("Not ok","Please enter valid user name and password" , "eyJhbGciOiJIUzI1NiIsInR5cC1...");
	return response;
	}
	}
	else
	{
	JSONObject response = userServ.userResponse("Not ok","User does not exists Please enter valid user name" , "eyJhbGciOiJIUzI1NiIsInR5cC2...");
	return response;
	}
	}
	@DeleteMapping(value="/deleteUser/{id}")
	public JSONObject delateUser(@PathVariable int id)
	{

	userRepo.deleteById(id);
	JSONObject response = userServ.userResponse("ok","User record getting deleted" , "eyJhbGciOiJIUzI1NiIsInR5cC2...");
	return response;

	}
	@PutMapping(value="updateUser/{id}")
	public JSONObject updateUser(@RequestBody User user ,@PathVariable int id)
	{
	User users=new User();
	String email = user.getEmail();
	String firstName = user.getFirstname();
	String lastName = user.getLastname();
	String password = user.getPassword();
	users.setId(id);
	users.setFirstname(firstName);
	users.setLastname(lastName);
	users.setEmail(email);
	users.setPassword(password);
	User saveUser = userRepo.save(users);
	if(saveUser!=null)
	{
	JSONObject response = userServ.userResponse("ok","User Details are Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return response;
	}
	else
	{
	JSONObject response = userServ.userResponse("Not ok","User Details are Not Getting Updated" , "eyJhbGciOiJIUzI1NiIsInR5dC2s...");
	return response;
	}
	
	}
	
	
	
}


