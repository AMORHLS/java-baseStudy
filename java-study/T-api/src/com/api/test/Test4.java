package com.api.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Test4 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		//生产随机不重复的100数字
		Random random =new Random();
		while (list.size()<100) {
			int i =random.nextInt(100)+1;
			if (!list.contains(i)) {
				list.add(i);
			}
		}
		  System.out.println(list);//排序前
		  Collections.sort(list);//对list进行排序
		  System.out.println(list);//排序后
		  System.out.println("最大值为"+list.get(99));
		  System.out.println("最小值为"+list.get(0));
	}
}
