package com.department;

public class Department {
	private int ID; // ���ű��
	private String name = "����"; // ��������
	private int amount = 0; // ��������
	private String responsibity = "����"; // ����ְ��
	private String manager = "������"; // ���ž���

	// �޲ι��췽��
	public Department() {

	}

	// ���ι��췽��
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
    //print��ӡ
	public void printDetail() {
		System.out.println("���ţ�" + this.name + "\n����" + this.manager
				+ "\n����ְ��" + this.responsibity + "\n********************");
	}
}
