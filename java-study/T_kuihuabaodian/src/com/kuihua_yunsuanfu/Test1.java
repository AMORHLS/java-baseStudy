package com.kuihua_yunsuanfu;

public class Test1 {
	public static void main(String[] args) {
		int i =3;
		/**
		 * &&��&�߼�������������ж�����Ϊ����Ϊ�棬Ϊ������Ϊ�٣�
		 * &&���ǰ��Ϊfalse�����治��ִ�У����Ϊtrue����ִ�У�
		  */
		if ((i++>5)&&(i++<9)) {
			System.out.println(i);
			System.out.println("��ϲ��ִ�������������!");
		}
		System.out.println(i);
	}
	/*public static void main(String[] args) {
		int i =3;
		//&���߶���ִ��
		if ((i++>5)&(i++<9)) {
			System.out.println(i);
			System.out.println("��ϲ��ִ�������������!");
		}
		System.out.println(i);
	}*/
	
}
/* class Test2{
	//����public�ͻᱨ��
	 //˵��ֻ�ܴ���һ��public��
}*/