package com.test2;


public class Bird extends Animal {
	private String  color;
	
	public Bird(int age,String name,String color){
		super(age, name);
		this.setColor(color);
	}
	public void printInfo(){
		System.out.println("����һֻ"+getColor()+"��"+getName()+"!\n�ҽ���2���ˣ�");
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

	
}
