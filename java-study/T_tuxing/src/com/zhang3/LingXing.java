package com.zhang3;

//菱形
public class LingXing {
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
		for (int i = 1; i < 5; i++) {
			//空白
			for (int j = 1; j <=i; j++) {
				System.out.print(" ");
			}
			//列数
			for (int j = 1; j < 9-2*i; j++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
	}
}
