package com.hls.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;


/**
 * 用户线程vs守护线程 --Runnable
 * @author AMOR
 */
class Daemon implements Runnable{
	@Override
	public void run() {
		System.out.println("进入守护线程"+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("退出守护线程"+Thread.currentThread().getName());
	}
	//写文件的方法
	private void writeToFile()throws Exception{
		File filename = new File("d:"+File.separator+"daemon.txt");//File.separator跨系统平台使用的分隔方法
		OutputStream os = new FileOutputStream(filename,true);
		int count = 0;
		while (count < 999) {
			os.write(("\r\nword"+count).getBytes());
			System.out.println("守护线程"+Thread.currentThread().getName()
					+"向文件中写入了word"+count++);
		Thread.sleep(1000);
		}
	}
}

public class DaemonThread {
	
	public static void main(String[] args) {
		System.out.println("进入主线程"+Thread.currentThread().getName());
		Daemon daemon = new Daemon();
		Thread thread = new Thread(daemon);
		thread.setDaemon(true); //设置为守护线程，在start()方法调用之前
		thread.start();
		//键盘输入  阻塞守护线程
		Scanner scanner = new Scanner(System.in);
		scanner.next();
		System.out.println("退出主线程"+Thread.currentThread().getName());
	}

}
