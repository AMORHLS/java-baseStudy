package com.kb.test;

import com.kb.Person1;

public class Test {
	public static void main(String[] args) {
		// ������������
		int num1=11;
		int num2=num1;
		System.out.println("num1���ڣ�"+num1);
		num2=22;
		System.out.println("��num1����num2���޸�num2��ֵ��"+"num1���ڣ�"+num1);
		System.out.println("*************************");
		//������������
		Person1 person1 =new Person1();
		person1.age=11;
		Person1 person2=person1;
		System.out.println("stu1.age���ڣ�"+person1.age);
		person2.age=22;
		System.out.println("��stu1���󸳸�stu2������޸�stu2��age���ԣ�"+"stu1.age���ڣ�"+person1.age);
		System.out.println("*************************");
	}
}
