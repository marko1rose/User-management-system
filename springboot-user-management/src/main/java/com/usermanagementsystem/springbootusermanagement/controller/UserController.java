package com.usermanagementsystem.springbootusermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.usermanagementsystem.springbootusermanagement.model.User;
import com.usermanagementsystem.springbootusermanagement.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping({ "/list", "/" })
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView("user-list");
		mav.addObject("users", userService.getAllUsers());
		return mav;
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/list";
	}

	@GetMapping("/addUserForm")
	public ModelAndView addUserForm() {
		ModelAndView mav = new ModelAndView("add-user-form");
		User newUser = new User();
		mav.addObject("user", newUser);
		return mav;
	}

	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long userId) {
		ModelAndView mav = new ModelAndView("add-user-form");
		User user = userService.getUser(userId);
		mav.addObject("user", user);
		return mav;
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		User user = userService.getUser(id);
		userService.deleteUser(user);
		return "redirect:/list";
	}

	@RequestMapping({ "/", "/search" })
	public ModelAndView search(String keyword) {
		ModelAndView mav = new ModelAndView("user-list");
		if (keyword != null) {
			mav.addObject("users", userService.getByKeyword(keyword));
		} else {
			mav.addObject("users", userService.getAllUsers());
		}
		return mav;
	}
}
