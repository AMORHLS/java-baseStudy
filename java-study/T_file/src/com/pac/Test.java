package com.pac;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("****************��ӭ����ע��ϵͳ********************");
		Scanner input = new Scanner(System.in);
		boolean flag = false;// ��ʶ��
		String pwd = null;
		String email = null;
		// ����Ҫ���ٴ����������Աȣ��˴�����Ϊȫ�ֱ���
		do {
			System.out.print("�������û�����");
			String name = input.next();
			if (name.length() >= 3) {
				// �û���������Ч
				System.out.print("���������룺");
				pwd = input.next().trim();
				System.out.println(pwd);
				if (pwd.length() >= 6) {
					// ����������Ч
					flag = true;
				} else {
					System.out.println("�������볤�Ȳ�С��6λ�����������룡");
				}			
			} else {
				System.out.println("�û������볤�Ȳ�С��3λ�����������룡");
			}
			if (flag) {
				System.out.print("�������������룺");
				String pwd2 = input.next().trim();
				System.out.println(pwd2);
				if (pwd2.equals(pwd)) {
					// ����������ͬ
					do{
					System.out.print("���ע�����䣺");
					email = input.next();
					int index = email.indexOf("@");// ��ȡ@���±�
					int index2 = email.indexOf(".");// ��ȡ.���±�
					if (index > 0 && index2 > 0 && index < index2 && index2!=(email.length()-1)) {
						flag = true;
					} else {
							flag = false;
					}
					}while(!flag);
					System.out.println("ע��ɹ������μ��û����������Լ��󶨵����䣡");
				} else {
					System.out.println("������������벻��ͬ��");
					flag = false;
				}
			}
		} while (!flag);

	}
}
