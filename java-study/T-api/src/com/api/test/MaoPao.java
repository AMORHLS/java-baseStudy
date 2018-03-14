package com.api.test;
//冒泡排序：升序
public class MaoPao {
	// 冒泡排序
		static void bubble_sort(int[] unsorted) {
			for (int i = 0; i < unsorted.length - 1; i++) {
				for (int j = 0; j < unsorted.length - 1 - i; j++) {
					if (unsorted[j] > unsorted[j + 1]) {
						int temp = unsorted[j];
						unsorted[j] = unsorted[j + 1];
						unsorted[j + 1] = temp;
					}
				}
			}
		}
	public static void main(String[] args) {
		int[] arr=new int[]{2,9,8,6,4};
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		//增强for遍历打印数组中元素
		for (int i : arr) {
			System.out.println(i);
		}
		
	}
}
