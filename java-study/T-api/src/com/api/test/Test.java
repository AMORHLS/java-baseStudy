package com.api.test;

import java.util.ArrayList;
import java.util.List;

import com.api.Dog;

public class Test {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Dog("ŷŷ", "ѩ����"));
		list.add(new Dog("����", "��������"));
		list.add(new Dog("�Ʒ�", "��������"));
		list.add(new Dog("����", "ѩ����"));
		System.out.println("������" + list.size() + "��������\n�ֱ���");
		System.out.println(list.toString());
		System.out.println("*****************");
		System.out.println("ɾ��ǰ������" + list.size() + "��������");
		list.remove(0);// ɾ��ָ��λ�õĹ������һ��
		/**
		 * removed��������Ĳ���������new��һ�����������������ԭ�е��Ǹ�new�Ĺ�����ͬһ�����������Զ���ͬ����ȷȷʵʵ����������
		 * ������������������и��Եĵ�ַ����ôԭ����equals�����ȵľ��Ƕ����ַ�����Բ�������removed�ﴫ��Ĳ���new�Ķ�����ʲô,
		 * equals������Ϊ�ǲ���ͬ�ģ�����ͬ�Ļ���removed�Ͳ��������ˣ�Ϊ����removed�����ã���ôremoved�������equals
		 * ������Ҫ���°�������һ�£���β��Ƚϵ�ַ�ˣ�ֻҪ�Ƚ����Ծ����ˣ�����������ͬ�����϶�����������һ����
		 */
		list.remove(new Dog("�Ʒ�", "��������"));// ɾ��ָ���Ĺ�
		System.out.println("ɾ��֮����" + list.size() + "��������\n�ֱ���\n" + list);
		System.out.println(list.contains(new Dog("����", "ѩ����")));
	}
}
