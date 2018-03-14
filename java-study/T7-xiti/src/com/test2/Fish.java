package com.test2;


public class Fish extends Animal {
	private int weight;
	
	public Fish(int age,String name,int weight){
		super(age, name);
		this.weight=weight;
	}
	public void printInfo(){
		System.out.println("我是一只"+getWeight()+"斤重的"+getName()+"!\n我今年"+getAge()+"岁了！");
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	
}
