package com.person;
//ѧ����Ϊ���������
public class Student extends Person {
	String school;
	
	public Student(){
		System.out.println("execute Student()");
	}
	public Student(String name,String school){
		super(name);//��������Ĵ��ι��췽��������ִ���޲ι��췽��
		this.school=school;
		System.out.println("execute Student(name,school)");
	}
}
