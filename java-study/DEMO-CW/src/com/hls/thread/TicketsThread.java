package com.hls.thread;
/**
 * ģ����Ʊ --Thread
 * @author AMOR
 */
class MyThread extends Thread{
	private int ticketsCount = 5;//Ʊ��
	
	private String name; //���ڣ�Ҳ�����̵߳�����
	
	public MyThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		while (ticketsCount > 0) {
			ticketsCount--;
			System.out.println(name+"�۳�һ��Ʊ��ʣ��Ʊ��Ϊ��"+ticketsCount);
		}
	}
}
public class TicketsThread {
	
	public static void main(String[] args) {
		//���������̣߳�ģ������������Ʊ
		MyThread m1 = new MyThread("����1");
		MyThread m2 = new MyThread("����2");
		MyThread m3 = new MyThread("����3");
		//�����̣߳���ʼ��Ʊ
		m1.start();
		m2.start();
		m3.start();
		
	}

}
