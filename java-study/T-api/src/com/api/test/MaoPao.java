package com.api.test;
//ð����������
public class MaoPao {
	// ð������
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
		//��ǿfor������ӡ������Ԫ��
		for (int i : arr) {
			System.out.println(i);
		}
		
	}
}
