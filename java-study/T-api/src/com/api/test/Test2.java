package com.api.test;
import java.util.LinkedList;

public class Test2 {
	public static void main(String[] args) {
		LinkedList  list =new LinkedList();
		list.add("������");
		list.add("�ֱ���");
		list.add("��ĸ");
		list.add("������");
		list.add("Ѧ����");
		System.out.println(list);
		list.addFirst("�����");	//��ͷ�����
		list.addLast("��ɮ");    //��β�����
		System.out.print(list+"\n");
		System.out.println(list.getFirst());//��ȡ��һ��
		System.out.println(list.getLast());//��ȡ���һ��
		list.remove(0);//�Ƴ���һ��  ָ��λ��
		System.out.print(list+"\n");
		list.remove("��ĸ");//�Ƴ�ָ������
		System.out.println(list);
		System.out.println(list.contains("Ѧ����"));
		System.out.println(list.size());//����Ԫ�صĸ���
	}

}
