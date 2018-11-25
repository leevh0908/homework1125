package cn.com.taiji.bean;

public class Boy {
private String sex;


public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public Boy(String sex) {
	super();
	this.sex = sex;
}

public Boy() {
	super();
}

@Override
public String toString() {
	return "Boy [sex=" + sex + "]";
}

}
