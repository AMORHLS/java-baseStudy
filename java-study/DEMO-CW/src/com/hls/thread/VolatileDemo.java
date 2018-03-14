package com.hls.thread;
/**
 * volatile 并不能保证变量在复合操作下的原子性
 * @author AMOR
 *
 */
public class VolatileDemo {
	private volatile int number = 0;
	
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
		this.number++;
	}
	
	public static void main(String[] args) {
		final VolatileDemo volatileDemo = new VolatileDemo();
		//在主线程启动500个线程的++操作
		for(int i = 0; i < 500; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					//匿名内部类要想访问外部类变量volatileDemo，外部类变量为final
					volatileDemo.add(); 
				}
			}).start(); //启动线程
		}
		/**
		 * 如果还有子线程还在运行，就让主线程让出cpu资源，直到所有的子线程运行完毕，主线程才开始运行
		 */
		while (Thread.activeCount()>1) {
			Thread.yield();
		
		}
		System.out.println("number: "+volatileDemo.getNum());
	}

}
