package com.api.test;

import java.util.ArrayList;

//ʹ��arrayList�洢100�������������,�ҵ����ֵ,��Сֵ�����������ܺ͡�
public class Test3 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		int[] arr = new int[100];//��������
		int sum=0;    //��ʼ�����
		for (int i = 0; i < 100; i++) {
			arr[i] = (int) (Math.random() * 100);// �õ������
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
		System.out.println("��СֵΪ"+arr[0]+"-"+"���ֵΪ"+arr[99]);
		System.out.println(list);
		System.out.println(list.size());
	}
}
