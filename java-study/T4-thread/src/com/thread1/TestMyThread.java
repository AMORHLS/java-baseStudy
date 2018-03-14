package com.thread1;

public class TestMyThread {
	public static void main(String[] args) {
		//创建对象
		MyThread mThread  = new MyThread();
		Thread thread = new Thread(mThread);
		thread.start();
	}
}
