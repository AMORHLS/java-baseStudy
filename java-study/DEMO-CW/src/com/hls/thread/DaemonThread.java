package com.hls.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;


/**
 * �û��߳�vs�ػ��߳� --Runnable
 * @author AMOR
 */
class Daemon implements Runnable{
	@Override
	public void run() {
		System.out.println("�����ػ��߳�"+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�˳��ػ��߳�"+Thread.currentThread().getName());
	}
	//д�ļ��ķ���
	private void writeToFile()throws Exception{
		File filename = new File("d:"+File.separator+"daemon.txt");//File.separator��ϵͳƽ̨ʹ�õķָ�����
		OutputStream os = new FileOutputStream(filename,true);
		int count = 0;
		while (count < 999) {
			os.write(("\r\nword"+count).getBytes());
			System.out.println("�ػ��߳�"+Thread.currentThread().getName()
					+"���ļ���д����word"+count++);
		Thread.sleep(1000);
		}
	}
}

public class DaemonThread {
	
	public static void main(String[] args) {
		System.out.println("�������߳�"+Thread.currentThread().getName());
		Daemon daemon = new Daemon();
		Thread thread = new Thread(daemon);
		thread.setDaemon(true); //����Ϊ�ػ��̣߳���start()��������֮ǰ
		thread.start();
		//��������  �����ػ��߳�
		Scanner scanner = new Scanner(System.in);
		scanner.next();
		System.out.println("�˳����߳�"+Thread.currentThread().getName());
	}

}
