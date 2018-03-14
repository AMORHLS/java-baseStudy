package com.api.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//思考题:1:使用arrayList存储100条任意打乱数字,对其进行倒序,升序。
public class Test5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		// 生产随机不重复的100数字
		Random random = new Random();
		while (list.size() < 100) {
			int i = random.nextInt(100) + 1;
			list.add(i);
		}
		System.out.println(list);// 排序前
		Collections.sort(list);// 对list进行排序：升序
		System.out.println(list);// 排序后
		Collections.reverse(list);// 对list进行排序：降序
		System.out.println(list);// 排序后
//2:在排序后的数组中使用二分法快速找到某个数。
		
	}
}
