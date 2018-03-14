package com.pac;
//使用字节输出流往文件内写东西
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		OutputStream foStream = null;// 声明为全局变量
		try {
			foStream = new FileOutputStream("f:/123.txt");
			String string = "好好学习java";
			// 将字符串打散为一个字节数组
			byte[] words = string.getBytes();
			try {
				foStream.write(words, 0, words.length);
				System.out.println("123文件已经被更新！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				foStream.close();//关闭输出流
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
