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
		//准备存贮name的map
		Map<String, Integer> map = new HashMap<String, Integer>();
		//通过类加载器来加载文件
		InputStream ips = TestOfHls.class.getResourceAsStream("/123.txt");
		//用字符流来解码
		BufferedReader in = new BufferedReader(new InputStreamReader(ips));
		//初始化读取的行数
		String line = null;
		//通过用BufferedReader的readLine()方法来整行读取（条件：不为空）
		while ((line = in.readLine()) != null) {
			//用String类的split（）方法分割（条件是按"，"）
			String[] result = line.split("，");
			//判断分割后的数组长度
			if (result.length == 3) {
				String name = result[1]; //下标为1的=user.name
				//计数
				Integer value = (Integer) map.get(name);
				if (value == null)
					value = 0;
				//把重复的姓名和姓名重复的次数放进map
				map.put(name, value + 1);
			}
		}
		//准备list存放map.value(姓名的重复次数)
		List<Integer> sortList = new ArrayList<Integer>();
		sortList.addAll(map.values());
		//排序  Collections.reverseOrder()
		Collections.sort(sortList, Collections.reverseOrder());
		//取键（去重后的姓名）
		Set<String> nameSet = map.keySet(); 
		//标识符
		boolean flag = true;
		//存放结果的集合
		List<User> resultList = new ArrayList<User>();
		// 依次取值
		for (int i = 0; i < sortList.size(); i++) {
			for (String name : nameSet) {
				// 判断map中键的值与之一样的键 若相同则进入
				if (map.get(name) == sortList.get(i)) {
					// 判断是否已将满足条件的值放入resultList中
					for (User user : resultList) {//空集合退出循环
						if (name == user.getName()) {
							flag = false;
						}
					}
					// 若未放入则放入
					if (flag) {
						resultList.add(new User(name,sortList.get(i)));
					}
				}
			}
		}
		//打印结果
		for (User user : resultList) {
			System.err.println(user.toString());
		}
	}

}
