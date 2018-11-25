package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



@ConfigurationProperties(prefix="my")
@Configuration
public class config {
	private String name;
	private String age;
	private String number;
	
	public config() {
		super();
	}
	public config(String name, String age, String number) {
		super();
		this.name = name;
		this.age = age;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "config [name=" + name + ", age=" + age + ", number=" + number + "]";
	}
	
}
