package com.api.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//˼����:1:ʹ��arrayList�洢100�������������,������е���,����
public class Test5 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		// ����������ظ���100����
		Random random = new Random();
		while (list.size() < 100) {
			int i = random.nextInt(100) + 1;
			list.add(i);
		}
		System.out.println(list);// ����ǰ
		Collections.sort(list);// ��list������������
		System.out.println(list);// �����
		Collections.reverse(list);// ��list�������򣺽���
		System.out.println(list);// �����
//2:��������������ʹ�ö��ַ������ҵ�ĳ������
		
	}
}
