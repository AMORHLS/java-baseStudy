package com.test2;


public class Bird extends Animal {
	private String  color;
	
	public Bird(int age,String name,String color){
		super(age, name);
		this.setColor(color);
	}
	public void printInfo(){
		System.out.println("我是一只"+getColor()+"的"+getName()+"!\n我今年2岁了！");
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

	
}
