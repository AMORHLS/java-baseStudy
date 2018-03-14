package com.hls.math;

public class User {
	private String name;
	private Integer age;
	private Integer count;

	public User(){}
	//有参构造
	public User(String name, Integer count) {
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", count=" + count + "]";
	}
	

}
