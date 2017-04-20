package com.wt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
	
	@GetMapping(value = "/testUrl")
	public String testUrl() {
		return "this is testUrl";
	}

}
