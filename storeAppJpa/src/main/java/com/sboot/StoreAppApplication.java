package com.sboot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.springframework.boot.ApplicationArguments;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
@interface Author{  

	String author();
} 

//Applying annotation  
class Hello{  
@Author(author="Prateek")  
public void sayHello(){System.out.println("hello ");}  
}


@SpringBootApplication
public class StoreAppApplication implements ApplicationRunner {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Hello hi = new Hello();
		hi.sayHello();
		
		Method m=hi.getClass().getMethod("sayHello");  
		  
		Author man=m.getAnnotation(Author.class);  
		System.out.println("hi : "+man.author());  
		SpringApplication.run(StoreAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>> HELLO STORE APP>>>>>>>>>>>>>>>>>>>");
		
	}
}

