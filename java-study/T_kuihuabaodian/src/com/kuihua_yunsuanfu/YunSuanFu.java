package com.kuihua_yunsuanfu;

public class YunSuanFu {
	/*public static void main(String[] args) {
		int x = 8;
		int y = 9;
		System.out.println((++x==y)&&(++x!=y));
		//++x先加再用，8+1=9==9真&&9+1=10!=9真     true;
		System.out.println(x);
		//x=10;
	}*/
	public static void main(String[] args) {
		int x = 8;
		int y = 9;
		System.out.println((++x!=y)&&(++x==y));
		//++x先加再用，8+1=9!=9假短路与 就不会执行下一句代码     false;
		System.out.println(x);
		//x=9;
	}
	
}
