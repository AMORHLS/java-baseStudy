package com.pac;
//ʹ���ֽ���������ļ���д����
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		OutputStream foStream = null;// ����Ϊȫ�ֱ���
		try {
			foStream = new FileOutputStream("f:/123.txt");
			String string = "�ú�ѧϰjava";
			// ���ַ�����ɢΪһ���ֽ�����
			byte[] words = string.getBytes();
			try {
				foStream.write(words, 0, words.length);
				System.out.println("123�ļ��Ѿ������£�");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				foStream.close();//�ر������
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
