package com.phone;

import com.phone_inter.Playing;
//��ͨ�ֻ���
public class CommonPhone extends HandSet implements Playing {
	public CommonPhone(){
		
	}
	public CommonPhone(String brand,String type){
		super(brand,type);
	}
	@Override
	public void playVideo(String name) {
		System.out.println("������Ƶ����"+name+"��");
		
	}
	@Override
	public void SendMess() {
		System.out.println("�������ֶ���");
		
	}
	@Override
	public void Call() {
		System.out.println("����ͨ��");
		
	}
}
