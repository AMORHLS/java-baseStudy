package com.zhang3;

//����
public class LingXing {
	public static void main(String[] args) {
		for (int i = 1; i <6; i++) {
			//�հ�
			for (int j = 1; j <6 - i; j++) {
				System.out.print(" ");
			}
			//����
			for (int j = 1; j < 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
		for (int i = 1; i < 5; i++) {
			//�հ�
			for (int j = 1; j <=i; j++) {
				System.out.print(" ");
			}
			//����
			for (int j = 1; j < 9-2*i; j++) {
				System.out.print("*");
			}
			System.out.println("*");
		}
	}
}
