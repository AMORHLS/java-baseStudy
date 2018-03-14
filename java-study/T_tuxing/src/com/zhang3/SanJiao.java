package com.zhang3;
//等腰三角形
public class SanJiao {
	public static void main(String[] args) {
		for (int i = 1; i <6; i++) {
			//空白
			for (int j = 1; j <6 - i; j++) {
				System.out.print(" ");
			}
			//列数
			for (int j = 1; j < 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println("*");

		}
	}
}
