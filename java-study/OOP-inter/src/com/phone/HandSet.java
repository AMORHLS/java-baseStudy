package com.phone;
//���ࣺ�ֻ���
public abstract class HandSet {
	private String brand ;
	private String type  ;
	
	public HandSet(){
		
	}
	public HandSet(String brand,String type ){
		this.brand=brand;
		this.type=type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//������
	public abstract void SendMess();
	//��绰
	public abstract void Call();
	//�ֻ���Ϣ����
	public void showInfo(){
		System.out.println("����һ̨"+brand+type);
	}
}
