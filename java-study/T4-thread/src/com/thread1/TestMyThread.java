package com.thread1;

public class TestMyThread {
	public static void main(String[] args) {
		//��������
		MyThread mThread  = new MyThread();
		Thread thread = new Thread(mThread);
		thread.start();
	}
}
