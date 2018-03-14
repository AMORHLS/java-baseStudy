package com.seri;

import java.io.Serializable;

//学生类
public class Student implements Serializable{//必须实现serializable接口
	private static final long serialVersionUID = 9060707552737545466L;
	//如果希望兼容修改后的class，需要设置相同的版本编号
	private String name;
	private String sex;
	//带参构造方法
	public Student(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
