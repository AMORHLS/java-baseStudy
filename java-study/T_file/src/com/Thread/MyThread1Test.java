package com.Thread;

public class MyThread1Test {
	public static void main(String[] args) {
		//�����̶߳���
		MyThread1 mt = new MyThread1();
		Thread thread= new Thread(mt);//�ɴ������
		//�����߳�
		thread.start();
	}
}
