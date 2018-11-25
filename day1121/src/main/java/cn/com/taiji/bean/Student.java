package cn.com.taiji.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
private String name;
private String age;
@Autowired
private Boy boy;



public Student() {
	super();
}
public Student(String name, String age) {
	super();
	this.name = name;
	this.age = age;
}

public Student(String name, String age, Boy boy) {
	super();
	this.name = name;
	this.age = age;

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
@Override
public String toString() {
	return "Student [name=" + name + ", age=" + age + ", boy=" + boy + "]";
}



}
