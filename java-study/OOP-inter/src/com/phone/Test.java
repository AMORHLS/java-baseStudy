package com.phone;

public class Test {
	public static void main(String[] args) {
		CommonPhone commonPhone =new CommonPhone("���ᰮ����","502");
		commonPhone.Call();
		commonPhone.SendMess();
		commonPhone.playVideo("��ɽ��");
		commonPhone.showInfo();
		System.out.println("************************");
		ZhinengPhone zhinengPhone =new ZhinengPhone("apple","6p");
		zhinengPhone.Call();
		zhinengPhone.SendMess();
		zhinengPhone.playVideo("������");
		zhinengPhone.netWork();
		zhinengPhone.takePhoto();
		zhinengPhone.showInfo();
	}
}
