package com.api;
//������Ϣ
public class Dog {
	private String name; //����
	private String strain;//Ʒ��
	//���췽��
	public Dog(){	
	}
	public Dog(String name,String strain){
		this.name=name;
		this.strain=strain;
	}
	//��дtoString����
	public String toString(){
		return this.name+this.strain;
		
	}
	//��дequals����
	public boolean equals(Object o){
		Dog dog =(Dog)o;//����ת��
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
