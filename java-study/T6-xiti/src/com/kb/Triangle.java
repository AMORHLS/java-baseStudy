package com.kb;

public class Triangle {
	public int a;
	public int b;
	public int c;
	//����һ���������ж�����������ô��
	public boolean isTriangle(int a,int b,int c){
		boolean flag=false;
		if(a+b>c&&a+c>b&&b+c>a){
			flag=true;
		}else{
		System.out.println("�ⲻ�ܹ���������");
		}
		return flag;
	}
	//����һ���������ж�����ʲô�����Σ�
	public String shape(int a,int b,int c){
		String shape="";
		if(a*a+b*b==c*c||a*a+c*c==b*b||b*b+c*c==a*a){
			shape="ֱ��������";
			System.out.println("����һ��ֱ��������");
		}else if((a*a+b*b<c*c) || (a*a+c*c<b*b)|| (b*b+c*c<a*a)){
			shape="�۽�������";
			System.out.println("����һ���۽�������");
		}else{
			shape="���������";
			System.out.println("����һ�����������");
		}
		return shape;
	}
}
