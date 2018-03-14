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
			// 获取文件路径
			File file = new File(filePath);
			// 判断这个文件是否存在
			if (file.isFile() && file.exists()) {
				// 读取路径（字节输入流）
				InputStream is = new FileInputStream(file);
				// 字符输入流去读取文件（可设置编码）
				InputStreamReader isReader = new InputStreamReader(is);
				// 借助BufferedReader整行读取（缓冲区的输入流，效率高）
				BufferedReader bReader = new BufferedReader(isReader);
				String textLine = null;
				while ((textLine = bReader.readLine()) != null) {
					list.add(textLine);
					// System.out.println(textLine);
				}
			} else {
				System.out.println("找不到指定的路径！");
			}
		} catch (Exception e) {
			System.out.println("读取文件异常！");
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
