package com.api.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Test4 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		//����������ظ���100����
		Random random =new Random();
		while (list.size()<100) {
			int i =random.nextInt(100)+1;
			if (!list.contains(i)) {
				list.add(i);
			}
		}
		  System.out.println(list);//����ǰ
		  Collections.sort(list);//��list��������
		  System.out.println(list);//�����
		  System.out.println("���ֵΪ"+list.get(99));
		  System.out.println("��СֵΪ"+list.get(0));
	}
}
