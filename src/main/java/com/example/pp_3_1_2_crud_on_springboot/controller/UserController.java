package com.example.pp_3_1_2_crud_on_springboot.controller;

import com.example.pp_3_1_2_crud_on_springboot.model.User;
import com.example.pp_3_1_2_crud_on_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(value = "/users")
	public String getUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";

	}

	@RequestMapping(value = "/addUser")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "saveUser";
	}

	@RequestMapping(value = "/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/updateUser", produces = "text/html; charset=utf-8")
	public String updateUser(@ModelAttribute("id") long id, ModelMap model) {
		model.addAttribute("user", userService.getUserById(id));
		return "saveUser";
	}

	@RequestMapping(value = "/deleteUser")
	public String deleteUser(@ModelAttribute("id") long id) {
		userService.removeUserById(id);
		return "redirect:/users";
	}

	
}