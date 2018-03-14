package com.DepartmentTest;

import com.department.PersonelDept;

public class PersonelDeptTest {
	public static void main(String[] args) {
		PersonelDept pd=new PersonelDept("人事部", "王经理", "负责公司的人才招聘。", 10);

		pd.printDetail();
	}
}
