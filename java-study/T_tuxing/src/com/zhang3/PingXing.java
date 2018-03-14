package com.zhang3;
//平行四边形5*5
public class PingXing {
	public static void main(String[] args) {
		//行
		for (int i = 0; i < 5; i++) {
			//打印空白处
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			//列数
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println("*");

		}
	}
}
