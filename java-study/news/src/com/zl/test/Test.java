package com.zl.test;

import java.util.List;

import com.zl.pojo.News;
import com.zl.service.NewsService;
import com.zl.service.impl.NewsServiceImpl;

//测试分页
public class Test {
	public static void main(String[] args) {
		//测试计算总数据
		NewsService service = new NewsServiceImpl();
		System.out.println(service.getTotalCount());
		//测试分页数据
		List<News> list = service.getPageNewsList(1,3);//第一参数不为0，从第几条数据开始查找
		for (News news : list) {
			System.out.println(news.getId()+"-"+news.getTitle());
		}
		
	}
}
