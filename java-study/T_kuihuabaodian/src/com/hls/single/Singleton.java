package com.hls.single;

//懒汉模式
/*
  1、单例类只能有一个实例。
  2、单例类必须自己创建自己的唯一实例。
  3、单例类必须给所有其他对象提供这一实例。
  */
public class Singleton {
	private static Singleton instance;
	private Singleton(){
		
	}
	public static synchronized Singleton getInstance(){
		if (instance==null) {
			instance=new Singleton();
		}
		return instance;
	}
}
