package com.department;

public class ResearchDept extends Department {
	//�з���
	private String speciality; //�з�����
	//���ι��췽��
	public ResearchDept(String name,String manager,String responsibity,String speciality){
		super(name,manager,responsibity); //�̳и���Ĺ��췽��
		this.setSpeciality(speciality);
	}
	public ResearchDept(String speciality){
		super();//Ĭ�ϵ��ø����޲ι��췽��
		this.speciality = speciality;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
