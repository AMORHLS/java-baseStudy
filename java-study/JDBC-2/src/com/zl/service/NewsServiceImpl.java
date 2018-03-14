package com.zl.service;

import java.util.List;

import com.zl.dao.NewsDao;
import com.zl.dao.impl.NewsDaoImpl;
import com.zl.pojo.News;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao;
	public NewsServiceImpl(){
		newsDao = new NewsDaoImpl();
	}
	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}
	//增加新闻
	public boolean addNews(News news){
		return newsDao.addNews(news);
	}

}
