package com.kb.test;

import java.util.Scanner;

import com.kb.Triangle;

public class TriangleTest {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		Scanner input = new Scanner(System.in);
		//String answer="";
		//���ڱ�����ʼ���������Լ�ȫ�ֺ;ֲ�����
		 do{
			System.out.println("�������һ���ߣ�");
			t.a = input.nextInt();
			System.out.println("������ڶ����ߣ�");
			t.b = input.nextInt();
			System.out.println("������������ߣ�");
			t.c = input.nextInt();
			t.isTriangle(t.a, t.b, t.c);
			t.shape(t.a, t.b, t.c);
			System.out.println("������(y/n)");
			//answer=input.next();
		}while (input.next().equals("y"));//while(answer.equals("y"));
		System.out.println("ллʹ�ã�");
	}
}
