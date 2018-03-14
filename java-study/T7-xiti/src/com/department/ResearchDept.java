package com.department;

public class ResearchDept extends Department {
	//研发部
	private String speciality; //研发方向
	//带参构造方法
	public ResearchDept(String name,String manager,String responsibity,String speciality){
		super(name,manager,responsibity); //继承父类的构造方法
		this.setSpeciality(speciality);
	}
	public ResearchDept(String speciality){
		super();//默认调用父类无参构造方法
		this.speciality = speciality;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
