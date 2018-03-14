package com.hls.thread;
/**
 * 模拟卖票 --Thread
 * @author AMOR
 */
class MyThread extends Thread{
	private int ticketsCount = 5;//票数
	
	private String name; //窗口，也就是线程的名字
	
	public MyThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		while (ticketsCount > 0) {
			ticketsCount--;
			System.out.println(name+"售出一张票，剩余票数为："+ticketsCount);
		}
	}
}
public class TicketsThread {
	
	public static void main(String[] args) {
		//创建三个线程，模拟三个窗口卖票
		MyThread m1 = new MyThread("窗口1");
		MyThread m2 = new MyThread("窗口2");
		MyThread m3 = new MyThread("窗口3");
		//启动线程，开始卖票
		m1.start();
		m2.start();
		m3.start();
		
	}

}
