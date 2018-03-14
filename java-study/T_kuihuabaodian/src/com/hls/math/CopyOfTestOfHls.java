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
		//准备存贮name的map
		Map<String, Integer> map = new HashMap<String, Integer>();
		//通过类加载器来加载文件
		InputStream ips = CopyOfTestOfHls.class.getResourceAsStream("/123.txt");
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
		ValueCompare vCompare = new ValueCompare(map);
		TreeMap<String, Integer> sortMap= new TreeMap<String, Integer>(vCompare);
		sortMap.putAll(map); 
		System.err.println(sortMap);
		
	
	}

}
