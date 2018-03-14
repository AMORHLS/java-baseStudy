package com.phone;

import com.phone_inter.Playing;
//普通手机类
public class CommonPhone extends HandSet implements Playing {
	public CommonPhone(){
		
	}
	public CommonPhone(String brand,String type){
		super(brand,type);
	}
	@Override
	public void playVideo(String name) {
		System.out.println("播放音频：《"+name+"》");
		
	}
	@Override
	public void SendMess() {
		System.out.println("发送文字短信");
		
	}
	@Override
	public void Call() {
		System.out.println("语音通话");
		
	}
}
