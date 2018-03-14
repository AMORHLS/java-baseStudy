package com.hls.thread;
/**
 * 模拟卖票 --Runnable
 * @author AMOR
 */
class MyThread2 implements Runnable{
	private int ticketsCount = 5;//票数
	
	
	@Override
	public void run() {
		while (ticketsCount > 0) {
			ticketsCount--;
			System.out.println(Thread.currentThread().getName()+"售出一张票，剩余票数为："+ticketsCount);
		}
	}
}
public class TicketsRunnable {
	
	public static void main(String[] args) {
		//创建三个线程，模拟三个窗口卖票
		MyThread2 m = new MyThread2();
		Thread th1 = new Thread(m,"窗口1");
		Thread th2 = new Thread(m,"窗口2");
		Thread th3 = new Thread(m,"窗口3");
		
		//启动线程，开始卖票
		th1.start();
		th2.start();
		th3.start();
		
	}

}
