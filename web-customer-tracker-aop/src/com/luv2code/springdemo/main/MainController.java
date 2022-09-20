package com.luv2code.springdemo.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/")
	public String processForm() {
		return "main-menu";
	}

}
