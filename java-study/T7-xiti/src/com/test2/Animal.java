package com.test2;


public abstract class Animal {
	private int age;
	private String name;
	
	public Animal(int age,String name){
		this.setAge(age);
		this.name=(name);
	}
	
	public abstract void printInfo();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
