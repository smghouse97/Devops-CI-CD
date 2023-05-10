package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class WebAppController {

// 	@GetMapping("/hello")
// 	public String hello() {
// 		return "<h1 style=\"color: hotpink; font-size: 40px; font: cursive;\">Hello, World </h1>";
// 	} 
// }
@RestController
public static class WebAppController {

	@GetMapping("/hello")
	public String hello() {
		return "<h1 style=\"color: hotpink; font-size: 40px; font: cursive;\"> Congratulations! You've successfully implemented the CI/CD pipeline and deployed a Java web application to AWS EC2 using Docker!</h1>";
	}
}

