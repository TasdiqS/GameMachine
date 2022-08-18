package com.project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.springboot.service.ServiceImpl;

@RestController
public class MyController {
	@Autowired
	ServiceImpl serviceimp;
	
	@PostMapping("/play")
	public String startGame(@RequestParam("id") long id, @RequestParam("gameTime") long gameTime) {
		return serviceimp.play(id, gameTime);
	}
	
	@GetMapping("/checkStatus")
	public String checkStatus() {
		return serviceimp.checkStatus();
	}
	

}
