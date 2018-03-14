package com.person;
//学生作为人类的子类
public class Student extends Person {
	String school;
	
	public Student(){
		System.out.println("execute Student()");
	}
	public Student(String name,String school){
		super(name);//调用人类的带参构造方法，将不执行无参构造方法
		this.school=school;
		System.out.println("execute Student(name,school)");
	}
}
