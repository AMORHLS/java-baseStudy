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
		//��ȡ��ǰϵͳʱ��
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("current time is:"+sFormat.format(calendar.getTime()));
		// ��ӡ��ǰname������
		System.out.println("name:"+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
