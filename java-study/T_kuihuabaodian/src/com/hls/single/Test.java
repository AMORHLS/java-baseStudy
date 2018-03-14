package com.hls.single;

public class Test {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printInfo(){
		System.out.println("�����Ϣ"+name);
	}
	//����ģʽ
	private static Test single =null;
	private Test(){
		
	}
	public static synchronized Test getInstance(){
		if (single==null) {
			single = new Test();
		}
		return single;
	}
	//����
	public static void main(String[] args) {
		Test t1 = Test.getInstance();
		t1.setName("����");
		t1.printInfo();
		Test t2 = Test.getInstance();
		t2.setName("����");
		t2.printInfo();
		if (t1==t2) {
			System.out.println("����ͬһ��ʵ��");
		}else if (t1!=t2) {
			System.out.println("������ͬ��ʵ��");
		}else {
			System.out.println("error");
		}
		
	}
}
