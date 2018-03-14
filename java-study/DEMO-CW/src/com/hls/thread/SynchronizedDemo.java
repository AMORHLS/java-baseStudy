package com.hls.thread;
/**
 * Synchronized ��֤�����ڸ��ϲ����µ�ԭ����
 * @author AMOR
 *
 */
public class SynchronizedDemo {
	private int number = 0;
	
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
		synchronized(this){ //��С������
			this.number++;
		}
	}
	
	public static void main(String[] args) {
		final SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
		//�����߳�����500���̵߳�++����
		for(int i = 0; i < 500; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					//�����ڲ���Ҫ������ⲿ�����volatileDemo���ⲿ�����Ϊfinal
					synchronizedDemo.add(); 
				}
			}).start(); //�����߳�
		}
		/**
		 * ����������̻߳������У��������߳��ó�cpu��Դ��ֱ�����е����߳�������ϣ����̲߳ſ�ʼ����
		 */
		while (Thread.activeCount()>1) {
			Thread.yield();
		}
		System.out.println("number: "+synchronizedDemo.getNum());
	}

}
