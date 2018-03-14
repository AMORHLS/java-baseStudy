package com.kb;

public class Triangle {
	public int a;
	public int b;
	public int c;
	//定义一个方法：判断这是三角形么？
	public boolean isTriangle(int a,int b,int c){
		boolean flag=false;
		if(a+b>c&&a+c>b&&b+c>a){
			flag=true;
		}else{
		System.out.println("这不能构成三角形");
		}
		return flag;
	}
	//定义一个方法：判断这是什么三角形？
	public String shape(int a,int b,int c){
		String shape="";
		if(a*a+b*b==c*c||a*a+c*c==b*b||b*b+c*c==a*a){
			shape="直角三角形";
			System.out.println("这是一个直角三角形");
		}else if((a*a+b*b<c*c) || (a*a+c*c<b*b)|| (b*b+c*c<a*a)){
			shape="钝角三角形";
			System.out.println("这是一个钝角三角形");
		}else{
			shape="锐角三角形";
			System.out.println("这是一个锐角三角形");
		}
		return shape;
	}
}
