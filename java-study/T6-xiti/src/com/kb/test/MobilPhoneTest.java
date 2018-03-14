package com.kb.test;

import com.kb.MobilPhone;

public class MobilPhoneTest {
	public static void main(String[] args) {
		MobilPhone mp=new MobilPhone();
		mp.brand="苹果";
		String detail=mp.buy("发工资啦");
		System.out.println(detail);
	}
}
