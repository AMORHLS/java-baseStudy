package com.seri;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SeriTest {
	public static void main(String[] args) throws Exception {
		//���л�     ����ѧ������
		//Student stu = new Student("����", "��");
		//���Ƕ���������ü���
		Student stu = new Student("�ֱ���", "��");
		Student stu1 = new Student("������", "Ů");
		Student stu2 = new Student("Ѧ����", "Ů");
		//����һ���ļ������
		FileOutputStream fos = new FileOutputStream("f:/stu.txt");
		//�������������
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(stu);
		list.add(stu1);
		list.add(stu2);
		oos.writeObject(list);
		oos.close();
		fos.close();
		System.out.println("���л��ɹ���");
		//�����л� �����ļ�������
		FileInputStream fis = new FileInputStream("f:/stu.txt");
		//��������������
		ObjectInputStream ois = new ObjectInputStream(fis);
		//Student student =(Student)ois.readObject();
		//�ü���ls������
		ArrayList<Student> ls = (ArrayList<Student>) ois.readObject(); //����ת��
		//���ϵĶ���ľ�����Ϣ��ô�ó���? ͨ��ѭ������
		for (Student student : ls) {
			System.out.println("����Ϊ��"+student.getName()+",�Ա�Ϊ"+student.getSex());
		}
		ois.close();
		fis.close();
	}
}
