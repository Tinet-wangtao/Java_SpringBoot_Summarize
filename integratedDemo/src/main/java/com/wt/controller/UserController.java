package com.wt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 * @author hohoTT
 *
 */
@RestController
@RequestMapping("/integratedDemo")
public class UserController {
	
	@GetMapping(value = "/getUsername")
	public String getUsername() {
		return "admin";
	}
	
}
