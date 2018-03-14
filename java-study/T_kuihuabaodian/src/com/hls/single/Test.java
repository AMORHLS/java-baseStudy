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
		System.out.println("输出信息"+name);
	}
	//懒汉模式
	private static Test single =null;
	private Test(){
		
	}
	public static synchronized Test getInstance(){
		if (single==null) {
			single = new Test();
		}
		return single;
	}
	//测试
	public static void main(String[] args) {
		Test t1 = Test.getInstance();
		t1.setName("张三");
		t1.printInfo();
		Test t2 = Test.getInstance();
		t2.setName("李四");
		t2.printInfo();
		if (t1==t2) {
			System.out.println("创建同一个实例");
		}else if (t1!=t2) {
			System.out.println("创建不同的实例");
		}else {
			System.out.println("error");
		}
		
	}
}
