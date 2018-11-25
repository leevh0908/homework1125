package cn.com.taiji.serives;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.com.taiji.bean.Boy;
import cn.com.taiji.bean.Student;

@Configuration
public class Config {
@Bean
public Boy boy() {
	Boy boy = new Boy();
	boy.setSex("1");
	return boy;
}
@Bean
public Student abab()	{ 
	

	Student student = new Student();
	
	return student;
}

}
