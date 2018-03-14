package com.hls.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized 保证变量在复合操作下的原子性
 * @author AMOR
 *
 */
public class LockDemo {
	private int number = 0;
	
	Lock lock = new ReentrantLock();
	
	public int getNum(){
		return this.number;
	}
	
	public void add(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.lock(); //上锁
		try{ //缩小锁粒度
			this.number++;
		}finally{
			lock.unlock(); //解锁
		}
	}
	
	public static void main(String[] args) {
		final LockDemo lockDemo = new LockDemo();
		//在主线程启动500个线程的++操作
		for(int i = 0; i < 500; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					//匿名内部类要想访问外部类变量volatileDemo，外部类变量为final
					lockDemo.add(); 
				}
			}).start(); //启动线程
		}
		/**
		 * 如果还有子线程还在运行，就让主线程让出cpu资源，直到所有的子线程运行完毕，主线程才开始运行
		 */
		while (Thread.activeCount()>1) {
			Thread.yield();
		}
		System.out.println("number: "+lockDemo.getNum());
	}

}
