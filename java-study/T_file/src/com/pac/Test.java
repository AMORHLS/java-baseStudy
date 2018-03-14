package com.pac;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("****************欢迎进入注册系统********************");
		Scanner input = new Scanner(System.in);
		boolean flag = false;// 标识符
		String pwd = null;
		String email = null;
		// 将来要和再次输入的密码对比，此处声明为全局变量
		do {
			System.out.print("请输入用户名：");
			String name = input.next();
			if (name.length() >= 3) {
				// 用户名输入有效
				System.out.print("请输入密码：");
				pwd = input.next().trim();
				System.out.println(pwd);
				if (pwd.length() >= 6) {
					// 密码输入有效
					flag = true;
				} else {
					System.out.println("密码输入长度不小于6位，请重新输入！");
				}			
			} else {
				System.out.println("用户名输入长度不小于3位，请重新输入！");
			}
			if (flag) {
				System.out.print("请重新输入密码：");
				String pwd2 = input.next().trim();
				System.out.println(pwd2);
				if (pwd2.equals(pwd)) {
					// 两次密码相同
					do{
					System.out.print("请绑定注册邮箱：");
					email = input.next();
					int index = email.indexOf("@");// 获取@的下标
					int index2 = email.indexOf(".");// 获取.的下标
					if (index > 0 && index2 > 0 && index < index2 && index2!=(email.length()-1)) {
						flag = true;
					} else {
							flag = false;
					}
					}while(!flag);
					System.out.println("注册成功，请牢记用户名和密码以及绑定的邮箱！");
				} else {
					System.out.println("两次输入的密码不相同！");
					flag = false;
				}
			}
		} while (!flag);

	}
}
