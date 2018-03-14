package com.api.test;

import java.util.ArrayList;

//使用arrayList存储100条任意打乱数字,找到最大值,最小值。计算数字总和。
public class Test3 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		int[] arr = new int[100];//定义数组
		int sum=0;    //初始数组和
		for (int i = 0; i < 100; i++) {
			arr[i] = (int) (Math.random() * 100);// 得到随机数
			sum+=i;
			for (int i1 = 0; i1 < arr.length - 1; i1++) {
				for (int j = 0; j < arr.length - 1 - i1; j++) {
					if (arr[j] > arr[j + 1]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
			list.add(arr[i]);
		}
		System.out.println(sum);
		System.out.println("最小值为"+arr[0]+"-"+"最大值为"+arr[99]);
		System.out.println(list);
		System.out.println(list.size());
	}
}
