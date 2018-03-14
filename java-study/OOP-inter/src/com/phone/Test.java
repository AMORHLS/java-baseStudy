package com.phone;

public class Test {
	public static void main(String[] args) {
		CommonPhone commonPhone =new CommonPhone("索尼爱立信","502");
		commonPhone.Call();
		commonPhone.SendMess();
		commonPhone.playVideo("南山南");
		commonPhone.showInfo();
		System.out.println("************************");
		ZhinengPhone zhinengPhone =new ZhinengPhone("apple","6p");
		zhinengPhone.Call();
		zhinengPhone.SendMess();
		zhinengPhone.playVideo("欢乐颂");
		zhinengPhone.netWork();
		zhinengPhone.takePhoto();
		zhinengPhone.showInfo();
	}
}
