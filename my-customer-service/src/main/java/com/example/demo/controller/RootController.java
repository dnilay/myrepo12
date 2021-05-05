package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
	
	private org.springframework.core.env.Environment env;
	
	


	public RootController(org.springframework.core.env.Environment env) {
		super();
		this.env = env;
	}




	@GetMapping("/")
	public String rootRedirect() {
		return "status up listining on port"+env.getProperty("local.server.port");
	}
	
}
