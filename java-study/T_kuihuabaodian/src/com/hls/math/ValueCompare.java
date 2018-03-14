package com.hls.math;

import java.util.Comparator;
import java.util.Map;

import com.hls.math.Test6.User;

public class ValueCompare implements Comparator {
	Map<String, Integer> map;

	public ValueCompare(Map<String, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		if (map.get(s1) >=map.get(s2)) {
			return -1;
		} else {
			return 1;
		}
	}

}
