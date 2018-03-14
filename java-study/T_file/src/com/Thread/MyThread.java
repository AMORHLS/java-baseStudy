package com.Thread;

public class MyThread extends Thread {
	private int count=0;
		public void run() {
			while (count<100) {
				count++;
				if (count%2==0) {
					System.out.println(count);
				}
			}
		}
	}

