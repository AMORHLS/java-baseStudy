package com.kb;

public class MobilPhone {
	public String brand;
	//无参构造
	public MobilPhone(){
		this.brand="诺基亚";
	}
	//带参构造
	public MobilPhone(String bra){
		this.brand=bra;
	}
	//方法重载
	public String buy(){
		return "没法工资，买一个"+brand+"牌子的手机吧！";
	}
	public String buy(String reason){
		return reason+"快买一个"+brand+"牌子的手机吧！";
	}
}
