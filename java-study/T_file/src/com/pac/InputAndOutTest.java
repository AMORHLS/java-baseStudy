package com.pac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputAndOutTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("f:/我的青春谁做主.txt");
			//fos = new FileOutputStream("f:/123.txt");//原内容覆盖
			fos = new FileOutputStream("f:/123.txt",true);//在原内容后面追加
			byte[] words = new byte[1024];
			int len = -1;
			try {
				//当知道结束条件用while
				while ((len=fis.read(words))!=-1) {
					fos.write(words,0, len);
				}
				//常见错误：（1）少写了一个字节    （2）多写了很多空格
				/*
				  while((fis.read())!=-1){
				  fis.read(words);
				  fos.write(words,0,words,length);
				 */
				System.out.println("文件复制完成！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();//先打开后关，后打开的先关！
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	} 
}
