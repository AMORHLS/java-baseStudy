package com.zl.service;

import java.util.List;

import com.zl.pojo.News;
import com.zl.service.impl.NewsServiceImpl;

public class TestNewsService {
	public static void main(String[] args) {
		// ≤‚ ‘–¬Œ≈∑÷“≥
		NewsService service = new NewsServiceImpl();
		System.out.println(service.getTotalCount());
		List<News> list = service.getPageNewsList(1, 3);
		for (News news : list) {
			System.out.println(news.getId() + "-" + news.getTitle());
		}

	}
}
