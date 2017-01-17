package com.blibli;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-configuration.xml");
		
		Bird bird2 = (Bird) context.getBean("birdBean");
		System.out.println(bird2.getName());
		System.out.println(bird2.getCount());
		bird2.setName("Burung gagak");
		bird2.getWing().doSomething();
		bird2.eat();
		bird2.eatSomething("nasi", "sentul");
		

	}

}
