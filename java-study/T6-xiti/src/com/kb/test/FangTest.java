package com.kb.test;

import java.util.Scanner;

import com.kb.Fang;

public class FangTest {
	public static void main(String[] args) {
	Fang fang=new Fang();
	Scanner input=new Scanner(System.in);
	System.out.println("����������");
	int l=input.nextInt();
	fang.setLoan(l);
	System.out.println("��ѡ��������ޣ�1��3�꣨36���£� 2��5�꣨60���£� 3��20�꣨240���£�");
	int y=input.nextInt();
	fang.setYear(y);
	fang.repay(l, y);
	}
}
