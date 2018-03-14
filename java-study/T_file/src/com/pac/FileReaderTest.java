package com.pac;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;



public class FileReaderTest {
	public static void main(String[] args) {
		//获取电脑默认的编码格式
		System.out.println(System.getProperty("file.encoding"));
		Reader fr = null;
		try {
		//	fr = new FileReader("f:简介.txt");
		FileInputStream  fis = new FileInputStream("f:简介.txt");
		try {
			fr = new InputStreamReader(fis,"GBK");
			StringBuffer s = new StringBuffer();
			char [] ch = new char[1024];
			int len = -1;
			try {
				while((len= fr.read(ch))!=-1){
					s.append(ch);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(s);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			StringBuffer s = new StringBuffer();
			char [] ch = new char[1024];
			int len = -1;
			try {
				while((len= fr.read(ch))!=-1){
					s.append(ch);
				}
				System.out.println(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
