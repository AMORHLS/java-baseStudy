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

public class ResultTest {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> map = new HashMap<String, Integer>();
		InputStream ips = ResultTest.class.getResourceAsStream("/123.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(ips));
		String line = null;
		while ((line = in.readLine()) != null) {
			dealLine(line, map);
		}
		Set nameSet = map.keySet();
		List<User> list = sortResults(map);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	private static List sortResults(Map map) {
		List v = new ArrayList();
		v.addAll(map.values());
		Collections.sort(v, Collections.reverseOrder());
		Set s = map.keySet();
		boolean b = true;
		List<Object> m = new ArrayList<Object>();
		for (int i = 0; i < v.size(); i++) {
			for (Object o : s) {
				if (map.get(o.toString()) == v.get(i)) {
					for (Object t : m) {
						if (o.toString() == ((User) t).getName()) {
							b = false;
						}
					}
					if (b) {
						m.add(new User(o.toString(), (Integer) v.get(i)));
					}
				}
			}
		}
		return m;
	}

	private static void dealLine(String line, Map map) {
		if (!"".equals(line.trim())) {
			String[] result = line.split("£¬");
			if (result.length == 3) {
				String name = result[1];
				Integer value = (Integer) map.get(name);
				if (value == null)
					value = 0;
				map.put(name, value + 1);
			}
		}
	}
}
