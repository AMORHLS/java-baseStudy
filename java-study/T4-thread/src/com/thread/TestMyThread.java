package com.thread;

public class TestMyThread {
	public static void main(String[] args) {
		//创建线程对象
		MyThread mt = new MyThread();
		//启动线程(不要使用run)
		mt.start();
	}
}
