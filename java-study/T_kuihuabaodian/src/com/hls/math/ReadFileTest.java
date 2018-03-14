package com.hls.math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTest {
	public static List<Object> readTxtFile(String filePath) {
		List<Object> list = new ArrayList<Object>();
		try {
			// ��ȡ�ļ�·��
			File file = new File(filePath);
			// �ж�����ļ��Ƿ����
			if (file.isFile() && file.exists()) {
				// ��ȡ·�����ֽ���������
				InputStream is = new FileInputStream(file);
				// �ַ�������ȥ��ȡ�ļ��������ñ��룩
				InputStreamReader isReader = new InputStreamReader(is);
				// ����BufferedReader���ж�ȡ������������������Ч�ʸߣ�
				BufferedReader bReader = new BufferedReader(isReader);
				String textLine = null;
				while ((textLine = bReader.readLine()) != null) {
					list.add(textLine);
					// System.out.println(textLine);
				}
			} else {
				System.out.println("�Ҳ���ָ����·����");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ��쳣��");
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		String filePath = "src/123.txt";
		List<Object> list = new ArrayList<Object>();
		list = readTxtFile(filePath);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
