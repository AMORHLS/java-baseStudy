package com.Thread;

public class MyThread1Test {
	public static void main(String[] args) {
		//创建线程对象
		MyThread1 mt = new MyThread1();
		Thread thread= new Thread(mt);//可创建多个
		//启动线程
		thread.start();
	}
}
