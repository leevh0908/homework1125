package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MessageService;

@RestController
public class hhhh {
	@Autowired
	private MessageService HellowordService;
	@RequestMapping("/go")
	public void aaa() {
		System.out.println(this.HellowordService.getMessage());
	}
}
