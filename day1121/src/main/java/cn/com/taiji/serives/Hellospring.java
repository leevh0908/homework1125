package cn.com.taiji.serives;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.taiji.bean.Boy;
import cn.com.taiji.bean.Student;

public class Hellospring {
public static void main(String[] args) {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
	Boy s =(Boy) applicationContext.getBean("boy1");
	System.out.println(s);
}
}
