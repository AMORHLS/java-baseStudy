package com.hls.thread;
/**
 * ģ����Ʊ --Runnable
 * @author AMOR
 */
class MyThread2 implements Runnable{
	private int ticketsCount = 5;//Ʊ��
	
	
	@Override
	public void run() {
		while (ticketsCount > 0) {
			ticketsCount--;
			System.out.println(Thread.currentThread().getName()+"�۳�һ��Ʊ��ʣ��Ʊ��Ϊ��"+ticketsCount);
		}
	}
}
public class TicketsRunnable {
	
	public static void main(String[] args) {
		//���������̣߳�ģ������������Ʊ
		MyThread2 m = new MyThread2();
		Thread th1 = new Thread(m,"����1");
		Thread th2 = new Thread(m,"����2");
		Thread th3 = new Thread(m,"����3");
		
		//�����̣߳���ʼ��Ʊ
		th1.start();
		th2.start();
		th3.start();
		
	}

}
