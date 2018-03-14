package com.zl.test;

import java.util.List;

import com.zl.pojo.News;
import com.zl.service.NewsService;
import com.zl.service.impl.NewsServiceImpl;

//���Է�ҳ
public class Test {
	public static void main(String[] args) {
		//���Լ���������
		NewsService service = new NewsServiceImpl();
		System.out.println(service.getTotalCount());
		//���Է�ҳ����
		List<News> list = service.getPageNewsList(1,3);//��һ������Ϊ0���ӵڼ������ݿ�ʼ����
		for (News news : list) {
			System.out.println(news.getId()+"-"+news.getTitle());
		}
		
	}
}
