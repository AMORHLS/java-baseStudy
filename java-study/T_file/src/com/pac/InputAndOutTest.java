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
			fis = new FileInputStream("f:/�ҵ��ഺ˭����.txt");
			//fos = new FileOutputStream("f:/123.txt");//ԭ���ݸ���
			fos = new FileOutputStream("f:/123.txt",true);//��ԭ���ݺ���׷��
			byte[] words = new byte[1024];
			int len = -1;
			try {
				//��֪������������while
				while ((len=fis.read(words))!=-1) {
					fos.write(words,0, len);
				}
				//�������󣺣�1����д��һ���ֽ�    ��2����д�˺ܶ�ո�
				/*
				  while((fis.read())!=-1){
				  fis.read(words);
				  fos.write(words,0,words,length);
				 */
				System.out.println("�ļ�������ɣ�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fos.close();//�ȴ򿪺�أ���򿪵��ȹأ�
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
