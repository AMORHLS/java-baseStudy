package com.thread1;

public class MyThread implements Runnable{
	private int count = 0;
	public void run() {
		while (count<100) {
			count++;
			if (count%2==0) {
				System.out.println(count);
			}
		}
	}
}
