package com.kb;

public class MobilPhone {
	public String brand;
	//�޲ι���
	public MobilPhone(){
		this.brand="ŵ����";
	}
	//���ι���
	public MobilPhone(String bra){
		this.brand=bra;
	}
	//��������
	public String buy(){
		return "û�����ʣ���һ��"+brand+"���ӵ��ֻ��ɣ�";
	}
	public String buy(String reason){
		return reason+"����һ��"+brand+"���ӵ��ֻ��ɣ�";
	}
}
