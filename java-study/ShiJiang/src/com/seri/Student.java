package com.seri;

import java.io.Serializable;

//ѧ����
public class Student implements Serializable{//����ʵ��serializable�ӿ�
	private static final long serialVersionUID = 9060707552737545466L;
	//���ϣ�������޸ĺ��class����Ҫ������ͬ�İ汾���
	private String name;
	private String sex;
	//���ι��췽��
	public Student(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
