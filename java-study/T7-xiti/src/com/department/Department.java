package com.department;

public class Department {
	private int ID; // 部门编号
	private String name = "待定"; // 部门名称
	private int amount = 0; // 部门人数
	private String responsibity = "待定"; // 部门职责
	private String manager = "无名氏"; // 部门经理

	// 无参构造方法
	public Department() {

	}

	// 带参构造方法
	public Department(String name, String manager, String responsibity) {
		this.name = name;
		this.manager = manager;
		this.responsibity = responsibity;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getResponsibity() {
		return responsibity;
	}

	public void setResponsibity(String responsibity) {
		this.responsibity = responsibity;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
    //print打印
	public void printDetail() {
		System.out.println("部门：" + this.name + "\n经理：" + this.manager
				+ "\n部门职责：" + this.responsibity + "\n********************");
	}
}
