package com.blibli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("birdBean")
public class Bird extends Animal{
	
	@Value("Burung Kakatua")
	private String name;
	
	@Value("0")
	private Integer count;
	
	@Autowired
	private Wing wing;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	

	public Wing getWing() {
		return wing;
	}

	public void setWing(Wing wing) {
		this.wing = wing;
	}

	@Override
	public void eat() {
		System.out.println("Bird is eating... WORM");
		
	}

	@Override
	public void move() {
		System.out.println("Bird is flying");
		
	}

	@Override
	public void makeSound() {
		System.out.println("chiirrrrpp");
	}

	@Override
	public String eatSomething(String food, String location) {
		System.out.println("Food "+food+ ", location "+location);
		return food+" "+location;
	}
}
