package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"hello"})
public class HellowordService implements MessageService {

	
	@Value("${name: lili}")
	private String name;
	@Override
	public String getMessage() {
	
		return name;
	}

}