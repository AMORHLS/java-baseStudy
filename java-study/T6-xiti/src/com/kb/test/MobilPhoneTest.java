package com.kb.test;

import com.kb.MobilPhone;

public class MobilPhoneTest {
	public static void main(String[] args) {
		MobilPhone mp=new MobilPhone();
		mp.brand="ƻ��";
		String detail=mp.buy("��������");
		System.out.println(detail);
	}
}
