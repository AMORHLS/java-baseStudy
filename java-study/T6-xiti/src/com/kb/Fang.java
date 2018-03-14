package com.kb;

public class Fang {
	private double zongLi;
	private double loan;
	private double liLv;
	private int year;
	public double repay;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getZongLi() {
		return zongLi;
	}
	public void setZongLi(double zongLi) {
		this.zongLi = zongLi;
	}
	public double getLoan() {
		return loan;
	}
	public void setLoan(double loan) {
		this.loan = loan;
	}
	public double getliLv() {
		return liLv;
	}
	public void setliLv(double liLv) {
		
		this.liLv = liLv;
	}
	public double repay(double repay,int year){
		switch (year) {
		case 1:
			repay=(getLoan()+getLoan()*0.0603)/36;
			break;
		case 2:
			repay=(getLoan()+getLoan()*0.0612)/60;
			break;
		case 3:
			repay=(getLoan()+getLoan()*0.0639)/240;
			break;
		default:
			break;
		}
		System.out.println("ÔÂ¹©Îª£º"+repay);
		return repay;
	}
	
}
