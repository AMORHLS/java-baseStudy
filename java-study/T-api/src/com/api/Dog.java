package com.api;
//狗狗信息
public class Dog {
	private String name; //名字
	private String strain;//品种
	//构造方法
	public Dog(){	
	}
	public Dog(String name,String strain){
		this.name=name;
		this.strain=strain;
	}
	//重写toString方法
	public String toString(){
		return this.name+this.strain;
		
	}
	//重写equals方法
	public boolean equals(Object o){
		Dog dog =(Dog)o;//向下转型
		if(this.name.equals(dog.name)&&this.strain.equals(strain)){
			return true;
		}else {
			return false;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
	
}
