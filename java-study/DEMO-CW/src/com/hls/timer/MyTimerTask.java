package com.hls.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
	private String name;
	
	public MyTimerTask(String inputName){
		name = inputName;
	}

	@Override
	public void run() {
		//获取当前系统时间
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current time is:"+sFormat.format(calendar.getTime()));
		// 打印当前name的内容
		System.out.println("name:"+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
