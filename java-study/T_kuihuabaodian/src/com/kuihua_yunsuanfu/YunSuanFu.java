package com.kuihua_yunsuanfu;

public class YunSuanFu {
	/*public static void main(String[] args) {
		int x = 8;
		int y = 9;
		System.out.println((++x==y)&&(++x!=y));
		//++x�ȼ����ã�8+1=9==9��&&9+1=10!=9��     true;
		System.out.println(x);
		//x=10;
	}*/
	public static void main(String[] args) {
		int x = 8;
		int y = 9;
		System.out.println((++x!=y)&&(++x==y));
		//++x�ȼ����ã�8+1=9!=9�ٶ�·�� �Ͳ���ִ����һ�����     false;
		System.out.println(x);
		//x=9;
	}
	
}
