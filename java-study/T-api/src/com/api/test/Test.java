package com.api.test;

import java.util.ArrayList;
import java.util.List;

import com.api.Dog;

public class Test {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Dog("欧欧", "雪纳瑞"));
		list.add(new Dog("亚亚", "拉布拉多"));
		list.add(new Dog("菲菲", "拉布拉多"));
		list.add(new Dog("美美", "雪纳瑞"));
		System.out.println("共计有" + list.size() + "条狗狗。\n分别是");
		System.out.println(list.toString());
		System.out.println("*****************");
		System.out.println("删除前共计有" + list.size() + "条狗狗。");
		list.remove(0);// 删除指定位置的狗狗如第一个
		/**
		 * removed方法传入的参数是他新new的一个对象，这和他集合里原有的那个new的狗不是同一个，尽管属性都想同，但确确实实是两个对象，
		 * 所以这两个对象各自有各自的地址，那么原生的equals方法比的就是对象地址，所以不管你在removed里传入的参数new的对象是什么,
		 * equals都会认为是不相同的，不相同的话，removed就不起作用了，为了让removed起作用，那么removed方法里的equals
		 * 方法就要重新把它定义一下，这次不比较地址了，只要比较属性就行了，所有属性相同，即认定两个对象是一样的
		 */
		list.remove(new Dog("菲菲", "拉布拉多"));// 删除指定的狗
		System.out.println("删除之后还有" + list.size() + "条狗狗。\n分别是\n" + list);
		System.out.println(list.contains(new Dog("美美", "雪纳瑞")));
	}
}
