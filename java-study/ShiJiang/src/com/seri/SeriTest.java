package com.seri;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SeriTest {
	public static void main(String[] args) throws Exception {
		//序列化     创建学生对象
		//Student stu = new Student("李明", "男");
		//若是多个对象，利用集合
		Student stu = new Student("贾宝玉", "男");
		Student stu1 = new Student("林黛玉", "女");
		Student stu2 = new Student("薛宝钗", "女");
		//创建一个文件输出流
		FileOutputStream fos = new FileOutputStream("f:/stu.txt");
		//创建输出对象流
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(stu);
		list.add(stu1);
		list.add(stu2);
		oos.writeObject(list);
		oos.close();
		fos.close();
		System.out.println("序列化成功！");
		//反序列化 创建文件输入流
		FileInputStream fis = new FileInputStream("f:/stu.txt");
		//创建对象输入流
		ObjectInputStream ois = new ObjectInputStream(fis);
		//Student student =(Student)ois.readObject();
		//用集合ls来接收
		ArrayList<Student> ls = (ArrayList<Student>) ois.readObject(); //向下转型
		//集合的对象的具体信息怎么拿出来? 通过循环遍历
		for (Student student : ls) {
			System.out.println("姓名为："+student.getName()+",性别为"+student.getSex());
		}
		ois.close();
		fis.close();
	}
}
