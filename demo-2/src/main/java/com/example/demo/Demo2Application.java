
package com.example.demo;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.GoodService;
import com.example.demo.service.HellowordService;
import com.example.demo.service.MessageService;

@SpringBootApplication
public class Demo2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	@Autowired
	private MessageService HellowordService;
	@Autowired
	private MessageService GoodService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.HellowordService.getMessage()+this.GoodService.getMessage());
	}
	private static final Logger logger = LoggerFactory.getLogger(Demo2Application.class);

	@PostConstruct
	public void logSomething() {
		logger.debug("Sample Debug Message");
		logger.info("Sample info Message");
		logger.trace("Sample trace Message");
		logger.error("Sample error Message");
		logger.warn("Sample warn Message");
	}
}
