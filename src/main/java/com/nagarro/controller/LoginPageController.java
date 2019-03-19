package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.model.User;
import com.nagarro.services.LoginService;
import com.nagarro.utility.LoginValidator;

@Controller
public class LoginPageController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login")
	public String loginPage(@ModelAttribute("login") User user, Model model) {
		System.out.println("inside login controller");
		if (LoginValidator.validateInput(user)) {
			if (loginService.loginUser(user))
				return "redirect:flightsearchscreen.html";
			else
				return "login";
		} else {
			return "login";
		}
	}
}
