package com.zhang3;
//ƽ���ı���5*5
public class PingXing {
	public static void main(String[] args) {
		//��
		for (int i = 0; i < 5; i++) {
			//��ӡ�հ״�
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			//����
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println("*");

		}
	}
}
