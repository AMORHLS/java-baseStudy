package com.phone;

import com.phone_inter.NetWorking;
import com.phone_inter.Playing;
import com.phone_inter.TakePhoto;

public class ZhinengPhone extends HandSet implements TakePhoto, NetWorking,
		Playing {
	public ZhinengPhone(){
		
	}
	public ZhinengPhone(String brand,String type){
		super(brand,type);
	}
	@Override
	public void playVideo(String name) {
		System.out.println("������Ƶ����"+name+"��");
		
	}

	@Override
	public void netWork() {
		System.out.println("����");
		
	}

	@Override
	public void takePhoto() {
		System.out.println("����");
		
	}

	@Override
	public void SendMess() {
		System.out.println("�������֡�ͼƬ����Ƶ�Ķ���");
		
	}

	@Override
	public void Call() {
		System.out.println("��Ƶͨ��");
		
	}

}
