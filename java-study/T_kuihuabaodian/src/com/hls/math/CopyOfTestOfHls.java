package com.hls.math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CopyOfTestOfHls {
	public static void main(String[] args) throws IOException {
		//׼������name��map
		Map<String, Integer> map = new HashMap<String, Integer>();
		//ͨ����������������ļ�
		InputStream ips = CopyOfTestOfHls.class.getResourceAsStream("/123.txt");
		//���ַ���������
		BufferedReader in = new BufferedReader(new InputStreamReader(ips));
		//��ʼ����ȡ������
		String line = null;
		//ͨ����BufferedReader��readLine()���������ж�ȡ����������Ϊ�գ�
		while ((line = in.readLine()) != null) {
			//��String���split���������ָ�����ǰ�"��"��
			String[] result = line.split("��");
			//�жϷָ������鳤��
			if (result.length == 3) {
				String name = result[1]; //�±�Ϊ1��=user.name
				//����
				Integer value = (Integer) map.get(name);
				if (value == null)
					value = 0;
				//���ظ��������������ظ��Ĵ����Ž�map
				map.put(name, value + 1);
			}
		}
		ValueCompare vCompare = new ValueCompare(map);
		TreeMap<String, Integer> sortMap= new TreeMap<String, Integer>(vCompare);
		sortMap.putAll(map); 
		System.err.println(sortMap);
		
	
	}

}
