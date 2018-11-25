package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@PropertySource(value = "classpath:application.properties")
@ConfigurationProperties(prefix = "liweihan")
@ToString
@Data
public class Boybean {
	
	private String name;
	private String age;
	private String sex;


}
