package cn.com.taiji.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.com.taiji.bean.Boy;
import cn.com.taiji.bean.Student;
import cn.com.taiji.serives.Config;

public class Test {
	@org.junit.Test
	public void test1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("cn.com.taiji.bean");
		context.refresh();
		context.registerShutdownHook();

		int beanDefinitionCount = context.getBeanDefinitionCount();
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(beanDefinitionCount);
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
	}
	@org.junit.Test
	public void aaaa() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Student bean = (Student)context.getBean("abab");
		System.out.println(bean);
	}
}