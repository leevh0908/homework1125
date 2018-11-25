package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Boybean;
import com.example.demo.bean.config;
import com.fasterxml.jackson.core.sym.Name;

@SpringBootApplication
@RestController
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/hello1")
	public String hello() {
		return "hello1" + config;

	}

	@Autowired
	private Boybean boybean;
	@Autowired
	private config config;
	// @Value("${name}")
	// private String name;
}