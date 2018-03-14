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
		System.out.println("播放视频：《"+name+"》");
		
	}

	@Override
	public void netWork() {
		System.out.println("上网");
		
	}

	@Override
	public void takePhoto() {
		System.out.println("拍照");
		
	}

	@Override
	public void SendMess() {
		System.out.println("发送文字、图片、视频的短信");
		
	}

	@Override
	public void Call() {
		System.out.println("视频通话");
		
	}

}
