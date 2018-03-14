package com.kb.test;

import java.util.Scanner;

import com.kb.Triangle;

public class TriangleTest {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		Scanner input = new Scanner(System.in);
		//String answer="";
		//关于变量初始化的问题以及全局和局部变量
		 do{
			System.out.println("请输入第一条边：");
			t.a = input.nextInt();
			System.out.println("请输入第二条边：");
			t.b = input.nextInt();
			System.out.println("请输入第三条边：");
			t.c = input.nextInt();
			t.isTriangle(t.a, t.b, t.c);
			t.shape(t.a, t.b, t.c);
			System.out.println("继续吗？(y/n)");
			//answer=input.next();
		}while (input.next().equals("y"));//while(answer.equals("y"));
		System.out.println("谢谢使用！");
	}
}
