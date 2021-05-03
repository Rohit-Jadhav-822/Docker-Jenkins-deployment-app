package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@GetMapping("/sample/{pathVariable}")
	public String getData(@PathVariable String pathVariable) {
		return "Welcome app is running..." + pathVariable;		
	}
}
