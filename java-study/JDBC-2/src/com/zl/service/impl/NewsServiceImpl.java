package com.zl.service.impl;

import java.util.List;

import com.zl.dao.NewsDao;
import com.zl.dao.impl.NewsDaoImpl;
import com.zl.pojo.News;
import com.zl.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao;

	public NewsServiceImpl() {
		newsDao = new NewsDaoImpl();
	}

	public List<News> getNewsList() {
		return newsDao.getNewsList();
	}

	// 增加新闻
	public boolean addNews(News news) {
		return newsDao.addNews(news);
	}

	// 根据id查询特定新闻信息
	public News getNewsById(int id) {
		return newsDao.getNewsById(id);
	}

	// 获取新闻总数据
	public int getTotalCount(){
		return newsDao.getTotalCount();
	}

	// 分页获取新闻数据(当前页码/页面容量)
	public List<News> getPageNewsList(int pageNo, int pageSize){
		return newsDao.getPageNewsList(pageNo, pageSize);
	}

}
