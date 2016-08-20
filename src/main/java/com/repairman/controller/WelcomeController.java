package com.repairman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/welcome",produces = {"text/html;charset=UTF-8"})
public class WelcomeController {

	@RequestMapping
	public String welcome() {
		return "welcome";
	}

}
