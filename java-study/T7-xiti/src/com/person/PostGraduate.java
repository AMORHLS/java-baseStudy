package com.person;
//研究生作为学生的子类
public class PostGraduate extends Student {
	String guide;    //导师
	public PostGraduate(){
		System.out.println("execute PostGraduate()");
	}
	public PostGraduate(String name,String school,String guide){
		super(name,school);
		this.guide=guide;
		System.out.println("execute PostGraduate(name,school,guide)");
	}
}
