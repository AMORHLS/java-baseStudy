package com.print;
//打印机
public class Printer {
	InkBox inkBox;//墨盒
	Paper paper;  //纸张
	public InkBox getInkBox() {
		return inkBox;
	}
	public void setInkBox(InkBox inkBox) {
		this.inkBox = inkBox;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public void print(){
		System.out.println("使用"+inkBox.getColor()+"的墨盒在"+paper.getsize()+"的纸张上打印");
	}
	
	//测试类
	public static void main(String[] args) {
		InkBox inkBox=new GrayInkBox();
		Paper paper=new A4Paper();
		Printer printer=new Printer();
		printer.setInkBox(inkBox);
		printer.setPaper(paper);
		printer.print();
			
		inkBox=new ColorInkBox();
		paper=new B5Paper();
		printer.setInkBox(inkBox);
		printer.setPaper(paper);
		printer.print();
	}
	
}
