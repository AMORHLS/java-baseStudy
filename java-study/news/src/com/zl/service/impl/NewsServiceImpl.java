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
		return newsDao.queryNews();
	}

	public boolean addNews(News news) {
		return newsDao.addNews(news);
	}

	// 根据ID查询特定新闻信息
	public News getNewsById(int id) {
		return newsDao.getNewsById(id);
	}
	
	//获取新闻总数据
	public int getTotalCount(){
		return newsDao.getTotalCount();
	}
	
	//分页获取新闻数据
	public List<News> getPageNewsList(int pageNo,int pageSize){
		return newsDao.getPageNewsList(pageNo, pageSize);
	}
	
	// 删除新闻标题根据id
	public boolean deleteNews(News news){
		return newsDao.deleteNews(news);
	}
}
