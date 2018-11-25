package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"good"})
public class GoodService implements MessageService {

	@Value("${name: mmmmm}")
	private String name;
	@Override
	public String getMessage() {
	
		return name;
	}

}
