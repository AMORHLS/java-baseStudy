package com.thread;

public class MyThread extends Thread{
	//@Override
	//�����߳� ���1-100��ż��
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
