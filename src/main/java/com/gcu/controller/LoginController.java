package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;

/**
 * The Class LoginController.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	/** The service. */
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	/** The security. */
	@Autowired
	private SecurityBusinessService security;
	
	/**
	 * Display.
	 */
	@GetMapping("/")
	public String display(Model model) {
		//display login form view
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	/**
	 * Do login.
	 */
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		//check for validation errors
		if(bindingResult.hasErrors()) {
			model.addAttribute("title", "Loging Form");
			return "login";
		}
		
		//print the form values
		System.out.println(String.format("Form with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()));
				
		//display the orders view
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		
		//navigate to the orders View
		return "orders";
	}
	
}
