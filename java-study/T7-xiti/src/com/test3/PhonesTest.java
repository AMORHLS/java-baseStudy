package com.test3;

public class PhonesTest {
	public static void main(String[] args) {
		Phones p =new IPhone();
		p.cell();
		Phones p1 =new APhone();
		p1.cell();
		Phones p2 =new WindowsPhone();
		p2.cell();
		APhone a =(APhone)p1;
		a.she();
	}

}
