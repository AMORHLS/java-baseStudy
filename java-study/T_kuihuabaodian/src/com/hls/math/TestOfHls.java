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

public class TestOfHls {
	public static void main(String[] args) throws IOException {
		//׼������name��map
		Map<String, Integer> map = new HashMap<String, Integer>();
		//ͨ����������������ļ�
		InputStream ips = TestOfHls.class.getResourceAsStream("/123.txt");
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
		//׼��list���map.value(�������ظ�����)
		List<Integer> sortList = new ArrayList<Integer>();
		sortList.addAll(map.values());
		//����  Collections.reverseOrder()
		Collections.sort(sortList, Collections.reverseOrder());
		//ȡ����ȥ�غ��������
		Set<String> nameSet = map.keySet(); 
		//��ʶ��
		boolean flag = true;
		//��Ž���ļ���
		List<User> resultList = new ArrayList<User>();
		// ����ȡֵ
		for (int i = 0; i < sortList.size(); i++) {
			for (String name : nameSet) {
				// �ж�map�м���ֵ��֮һ���ļ� ����ͬ�����
				if (map.get(name) == sortList.get(i)) {
					// �ж��Ƿ��ѽ�����������ֵ����resultList��
					for (User user : resultList) {//�ռ����˳�ѭ��
						if (name == user.getName()) {
							flag = false;
						}
					}
					// ��δ���������
					if (flag) {
						resultList.add(new User(name,sortList.get(i)));
					}
				}
			}
		}
		//��ӡ���
		for (User user : resultList) {
			System.err.println(user.toString());
		}
	}

}
