package com.string;

public class Test {
	//����String ��==
	public static void main(String[] args) {
		String s1 ="hello";//�ַ�����
		String s2 =new String("hello");//����һ������
		
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		
		System.out.println("***********************");
		
		String s3 ="hello";
		String s4 =new String("Hello");
		
		System.out.println(s3.equals(s4));
		System.out.println(s3==s4);
	}
}
