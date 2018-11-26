# demo

## 通过xml配置bean


添加依赖
```
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
</dependency>
  
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>javax.inject</groupId>
    <artifactId>javax.inject</artifactId>
    </dependency>

```
编写xml

```
<beans xmlns="http://www.springframework.org/schema/beans"
	   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	   xmlns:context="http://www.springframework.org/schema/context"
	   xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-4.0.xsd">
                        
	<bean id="helloworld" class="test.HelloSpring">
	</bean>
	<bean id="xiaoLi" class="test2.XiaoLi">
	</bean>
	<bean id="xiaoMei" class="test2.XiaoMei">
	</bean>
	<bean id="getMarried" class="test2.Married">
		<property name="gril" ref="xiaoLi"></property>
	</bean>
	
	<bean id="customer1" class="test3.Customer">
	</bean>
	<bean id="customer2" class="test3.Customer"><!-- 属性注入方式 -->
		<property name="name" value="Tomcat"></property>
		<property name="sex" value="male"></property>
		<property name="age" value="24"></property>
	</bean>
	<bean id="customer3" class="test3.Customer"><!-- 构造函数注入方式 -->
		<constructor-arg type="String" value="Jack"></constructor-arg>
		<constructor-arg type="String" value="male"></constructor-arg>
		<constructor-arg type="int" value="23"></constructor-arg>
	</bean>
	<bean id="customer4" class="test3.Customer"><!-- 索引注入方式 -->
		<constructor-arg index="0" value="Rose"></constructor-arg>
		<constructor-arg index="1" value="female"></constructor-arg>
		<constructor-arg index="2" value="25"></constructor-arg>
	</bean>
	
    <bean id="customerFactory" class="test4.CustomerFactory"><!-- 动态工厂注入方式 -->
	</bean>
	<bean id="customer" factory-bean="customerFactory" factory-method="createCustomer">
	</bean>

```
测试

```
public class Test {
public static void main(String[] args) {
	ApplicationContext aContext=new ClassPathXmlApplicationContext("com/iss/demo/beans.xml");
	Customer customer=(Customer) aContext.getBean("");
	System.out.println(customer);
	
}
}
```

## 注解配置bean
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
						   http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-4.0.xsd">
	<!-- <bean id="boy" class="cn.com.taiji.bean.Boy"> <constructor-arg name="sex" 
		value="nan"></constructor-arg> </bean> -->
	<!-- <bean id="boy1" class="cn.com.taiji.bean.Boy">
		<constructor-arg type="String" value="nannan"></constructor-arg>
	</bean> -->
	<context:component-scan
		base-package="cn.com.taiji.serives"></context:component-scan>


</beans>


```
serives类

```
@Service
public class Helloserives {
	@Value("sjhaf")
private String adress;
@Autowired
private Boy boy;

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Helloserives(String adress) {
		super();
		this.adress = adress;
	}

	public Helloserives() {
		super();
	}

	@Override
	public String toString() {
		return "Helloserives [adress=" + adress + "]";
	}
	
}

```
测试

```
public class Hellospring {
public static void main(String[] args) {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
	Boy s =(Boy) applicationContext.getBean("boy1");
	System.out.println(s);
}
}
```


## 通过 .class配置

添加@Configuration注解

```
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

```
测试
```

	@org.junit.Test
	public void aaaa() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Student bean = (Student)context.getBean("abab");
		System.out.println(bean);
	}
}
```



## 相应页面的请求及数据返回

需要注解 @Restcontroller 
@requestMapping("xxx") 相应xxx页面的请求

@RestController
public class Application {
​    @Value("${name}")
​    private String name;
​    @RequestMapping("hello")
​    public String hello() {
​        return name;    
​    }



## 使用.properties 或 .yml 文件 配置类属性值

propertise文件编写
cat.name=cat
dog.name=dogs类文件的编写
需要注解 @component
@configurationPropertise(prefix="xxx") xxx 代表propertise 路径 
类中的属性需要与propertise对应
@PropertySource(value="test.properties")
读取指定propertise下的内容
动态配置内部及外部配置
需要在类上添加注解 @Profile({"xxx"}) 加载xxx 下的配置
加载“hello”下的内容

@Component
@Profile({"hello"})
public class GoodBye implements MessageHello {
​    @Value("${name:lili}")
​    private String name;
​    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "GoodBye [name=" + name + "]";
    }
    
    @Override
    public String Message() {
        // TODO Auto-generated method stub
        return "Good"+this.name;
    }

}
propertise文件配置
name: my
spring:
  profiles:
    active: 
---
spring:
  profiles: GoodBye
name: GoodBye  



## 启动时执行CommandLineRunner

```
@Bean
public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	return args ->{
		System.out.println("list:bean" + ctx.getBeanDefinitionCount());
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String string : beanNames) {
			System.out.println(beanNames);
		}
	};
}
@Bean
public static CommandLineRunner testA() {
	CommandLineRunner runner =new CommandLineRunner() {
		
		@Override
		public void run(String... args) throws Exception {
			System.out.println("在这里");	
			
		}
	};
```

## ApplicationListener监听器

```
@Bean
public ApplicationListener<ApplicationEvent> helloListener(){
	final String HELLO_URL="/hello";
	return (ApplicationEvent event)->{
		if(event instanceof ServletRequestHandledEvent) {
			ServletRequestHandledEvent e=(ServletRequestHandledEvent) event;
			if(e.getRequestUrl().equals(HELLO_URL)) {
				System.out.println("123456"+demo2.getMessage());
			}
		}
	};
}
```

## Spring boot Admin监控

### 1123：8080

1. pom.xml

   ```xml
   		<!--引入admin server依赖-->
   		<dependency>
   			<groupId>de.codecentric</groupId>
   			<artifactId>spring-boot-admin-server</artifactId>
   			<version>1.5.6</version>
   		</dependency>
   		<!--admin server的展示-->
   		<dependency>
   			<groupId>de.codecentric</groupId>
   			<artifactId>spring-boot-admin-server-ui</artifactId>
   			<version>1.5.6</version>
   		</dependency>
   ```

2. 启动类上加注解

```java
@Configuration
@EnableAutoConfiguration
@EnableAdminServer

```

1.访问http://localhost:8080

### demo3：8083

1. pom.xml

```xml
<dependency>
   <groupId>de.codecentric</groupId>
   <artifactId>spring-boot-admin-starter-client</artifactId>
   <version>1.5.6</version>
</dependency>
```

1. application.properties

```properties
spring.boot.admin.url=http://localhost:8080  
management.security.enabled=false
```

## 使用 spring.profiles.active 及 @profile 注解 动态化配置内部及外部配置

### 1.application.yml

name1: dou
hello: good evening
spring: 
   profiles: 

​      active: hello

spring: 
   profiles: googbye,dev

name1: everyone

spring: 
   profiles: hello
name1: david

### 2.@profile

@Profile({"hello"})

## 端点配置

执行器端点允许你监控应用及与应用进行交互。Spring Boot包含很多内置的端点，你也可以添加自己的。例如，health端点提供了应用的基本健康信息。 

### 配置端点

management: 
   security: 
​     enabled: false
   port: 8888
   context-path: /abc

### 自定义端点

endpoints:
  actuator:
​    enabled: true
  shutdown:
​    enabled: true
info:
  app:
​    name: spring-boot-actuator
​    version: 1.0.0

## 日志

常用日志级别有四个，优先级从高到低分别是ERROR、WARN、INFO、DEBUG 。

### 输出日志

### 输出日志

```
public void queryObligations() {  
    log.debug("query obligations start...");  
    log.error("An error occurred during the query");  
    log.debug("query obligations end...");  
}  
```

### 2.定义日志级别

logging.level.root=WARN
logging.level.org.springframework.web=DEBUG
logging.file=my.log
