package com.person;

public class Person {
	String name;
	//无参构造方法
	public Person(){
		System.out.println("execute Person()");
	}
	//带参构造方法
	public Person(String name){
		this.name=name;
		System.out.println("execute Person(name)");
	}
}
