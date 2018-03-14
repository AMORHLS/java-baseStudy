package com.hls.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized ��֤�����ڸ��ϲ����µ�ԭ����
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
		lock.lock(); //����
		try{ //��С������
			this.number++;
		}finally{
			lock.unlock(); //����
		}
	}
	
	public static void main(String[] args) {
		final LockDemo lockDemo = new LockDemo();
		//�����߳�����500���̵߳�++����
		for(int i = 0; i < 500; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					//�����ڲ���Ҫ������ⲿ�����volatileDemo���ⲿ�����Ϊfinal
					lockDemo.add(); 
				}
			}).start(); //�����߳�
		}
		/**
		 * ����������̻߳������У��������߳��ó�cpu��Դ��ֱ�����е����߳�������ϣ����̲߳ſ�ʼ����
		 */
		while (Thread.activeCount()>1) {
			Thread.yield();
		}
		System.out.println("number: "+lockDemo.getNum());
	}

}
