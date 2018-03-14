package com.api.test;
import java.util.LinkedList;

public class Test2 {
	public static void main(String[] args) {
		LinkedList  list =new LinkedList();
		list.add("林黛玉");
		list.add("贾宝玉");
		list.add("贾母");
		list.add("王熙凤");
		list.add("薛宝钗");
		System.out.println(list);
		list.addFirst("孙悟空");	//给头部添加
		list.addLast("唐僧");    //给尾部添加
		System.out.print(list+"\n");
		System.out.println(list.getFirst());//获取第一个
		System.out.println(list.getLast());//获取最后一个
		list.remove(0);//移除第一个  指定位置
		System.out.print(list+"\n");
		list.remove("贾母");//移除指定对象
		System.out.println(list);
		System.out.println(list.contains("薛宝钗"));
		System.out.println(list.size());//集合元素的个数
	}

}
