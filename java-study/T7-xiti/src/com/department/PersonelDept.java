package com.department;

public class PersonelDept extends Department {
	//���²�
	private int count;    //���¼ƻ���Ƹ����
	public PersonelDept(String name,String manager,String responsibity,int count){
		super(name,manager,responsibity);//super���ø�����вι��췽��
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
		System.out.println("���¼ƻ���Ƹ������"+this.count+"\n");
	}
}
