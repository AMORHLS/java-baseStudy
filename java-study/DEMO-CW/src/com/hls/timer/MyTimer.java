package com.hls.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class MyTimer {
	
	public static void main(String[] args) {
		//����һ��Timerʵ��
		Timer timer = new Timer();
		//����һ��MyTimerTaskʵ��
		MyTimerTask myTimerTask = new MyTimerTask("No.1");
		//ͨ��Timer��ʱ��Ƶ�ʵ���myTimerTask��ҵ���߼�
		//����һ��ִ�����ڵ�ǰʱ�������֮��֮��ÿ��һ���Ӿ�ִ��һ��
		/*timer.schedule(myTimerTask, 2000L,1000L);*/
		/**
		 * ��ȡ��ǰʱ�䣬�����óɾ��뵱ǰʱ������֮���ʱ��
		 */
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sFormat.format(calendar.getTime()));//��ǰʱ��
		calendar.add(Calendar.SECOND, 3);
		myTimerTask.setName("schedule1");
		timer.schedule(myTimerTask, calendar.getTime());
		
		
	}

}
