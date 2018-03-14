package com.kuihua_yunsuanfu;

public class Test1 {
	public static void main(String[] args) {
		int i =3;
		/**
		 * &&和&逻辑运算符，都是判断两边为真则为真，为假则结果为假！
		 * &&如果前边为false，后面不会执行，如果为true，则执行！
		  */
		if ((i++>5)&&(i++<9)) {
			System.out.println(i);
			System.out.println("恭喜，执行完了条件语句!");
		}
		System.out.println(i);
	}
	/*public static void main(String[] args) {
		int i =3;
		//&两边都会执行
		if ((i++>5)&(i++<9)) {
			System.out.println(i);
			System.out.println("恭喜，执行完了条件语句!");
		}
		System.out.println(i);
	}*/
	
}
/* class Test2{
	//加上public就会报错
	 //说明只能存在一个public类
}*/