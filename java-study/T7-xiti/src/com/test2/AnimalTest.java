package com.test2;


public class AnimalTest {
	public static void main(String[] args) {
		Animal a1=new Bird(4, "��", "��ɫ");
		a1.printInfo();
		System.out.println();
		Animal a =new Fish(2, "��", 5);
		a.printInfo();
	}
}
