package com.kb.test;

import java.util.Scanner;

import com.kb.Fang;

public class FangTest {
	public static void main(String[] args) {
	Fang fang=new Fang();
	Scanner input=new Scanner(System.in);
	System.out.println("请输入贷款金额：");
	int l=input.nextInt();
	fang.setLoan(l);
	System.out.println("请选择贷款年限：1、3年（36个月） 2、5年（60个月） 3、20年（240个月）");
	int y=input.nextInt();
	fang.setYear(y);
	fang.repay(l, y);
	}
}
