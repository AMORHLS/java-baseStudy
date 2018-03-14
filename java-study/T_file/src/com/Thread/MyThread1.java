package com.Thread;

public class MyThread1 implements Runnable {
	public void run(){
		for(int i=0;i<101;i++){
			if (i%2==0) {
				System.out.println(i);
			}
		}
	}
}
