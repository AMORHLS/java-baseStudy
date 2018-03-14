package com.pac;

import java.io.File;
import java.io.IOException;
//文件操作
public class FileDemo {
	//创建文件：createNewFile  方法通过对象来操作
	public void create(File file){
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("文件已经创建！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	//查看文件的相关信息
	public void showFileInfo(File file){
		if (file.exists()) {
			//文件存在，查看其信息
			if (file.isFile()) {
				//是文件
				System.out.println("该文件名："+file.getName());
				System.out.println("文件的相对路径"+file.getPath());
				System.out.println("文件的绝对路径"+file.getAbsolutePath());
				System.out.println("文件的大小"+file.length()+"字节");
			}
			if (file.isDirectory()) {
				System.out.println("此文件是目录！");
			}
		}else {
			System.out.println("文件不存在");
		}
	}
	//删除文件
	public void delete(File file){
		if (file.exists()) {
			file.delete();
			System.out.println("文件已经删除！");
		}
	}
	public static void main(String[] args) {
		FileDemo fileDemo = new FileDemo();
		File file = new File("f:/helishi/test.txt");
		//File file = new File("test.txt");
		fileDemo.create(file);
		//调用showFileInfo
		fileDemo.showFileInfo(file);
		fileDemo.delete(file);
	}
	
}
