package com.test2;


public class Fish extends Animal {
	private int weight;
	
	public Fish(int age,String name,int weight){
		super(age, name);
		this.weight=weight;
	}
	public void printInfo(){
		System.out.println("����һֻ"+getWeight()+"���ص�"+getName()+"!\n�ҽ���"+getAge()+"���ˣ�");
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	
}
