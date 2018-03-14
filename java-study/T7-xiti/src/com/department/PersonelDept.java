package com.department;

public class PersonelDept extends Department {
	//人事部
	private int count;    //本月计划招聘人数
	public PersonelDept(String name,String manager,String responsibity,int count){
		super(name,manager,responsibity);//super调用父类的有参构造方法
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void printDetail() {
		super.printDetail();
		System.out.println("本月计划招聘人数："+this.count+"\n");
	}
}
