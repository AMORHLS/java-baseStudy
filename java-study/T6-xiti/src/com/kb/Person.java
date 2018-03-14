package com.kb;

public class Person {

	private String name;
	private String gender;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (gender.equals("男") || gender.equals("女")) {
			this.gender = gender;
		} else {
			System.out.println("****性别不合法****");
		}

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0 || age > 150) {
			System.out.println("输入的年龄为：" + age + ",该年龄不合法，将重置***");
			return;
		}
		this.age = age;
	}

	// 构造方法
	public Person() {
		this.name = "无名氏";
		this.gender = "男";
		this.age = 18;
	}

	public Person(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	// 方法：自我介绍
	public void say() {
		System.out.println("自我介绍一下\r\n姓名：" + this.name + "\r\n性别："
				+ this.gender + "\r\n年龄：" + this.age + "岁");
	}
}

