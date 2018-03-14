package com.hls.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

public class MyTimer {
	
	public static void main(String[] args) {
		//创建一个Timer实例
		Timer timer = new Timer();
		//创建一个MyTimerTask实例
		MyTimerTask myTimerTask = new MyTimerTask("No.1");
		//通过Timer定时定频率调用myTimerTask的业务逻辑
		//即第一次执行是在当前时间的两秒之后，之后每隔一秒钟就执行一次
		/*timer.schedule(myTimerTask, 2000L,1000L);*/
		/**
		 * 获取当前时间，并设置成距离当前时间三秒之后的时间
		 */
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sFormat.format(calendar.getTime()));//当前时间
		calendar.add(Calendar.SECOND, 3);
		myTimerTask.setName("schedule1");
		timer.schedule(myTimerTask, calendar.getTime());
		
		
	}

}
