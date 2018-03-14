package com.Thread;

public class MyThread extends Thread {
		/*public void run() {
			int count=0;
			while (count<100) {
				count++;
				if (count%2==0) {
					System.out.println(count);
				}
			}
		}*/
		public void run() {
		  int i=0;
		  for(;i<100;){
			i++;
			if (i%2==0) {
				System.out.println(i);
			}
		}
	}
	}

