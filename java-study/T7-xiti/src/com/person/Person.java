package com.person;

public class Person {
	String name;
	//�޲ι��췽��
	public Person(){
		System.out.println("execute Person()");
	}
	//���ι��췽��
	public Person(String name){
		this.name=name;
		System.out.println("execute Person(name)");
	}
}
