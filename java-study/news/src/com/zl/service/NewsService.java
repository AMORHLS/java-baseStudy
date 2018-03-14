package com.zl.service;

import java.util.List;

import com.zl.pojo.News;

public interface NewsService {
	//查询全部新闻
	public List<News> getNewsList();
	
	//增加新闻
	public boolean addNews(News news);
	
	//根据ID查询特定新闻信息
	public News getNewsById(int id);
	
	//获取新闻总数据
	public int getTotalCount();
	
	//分页获取新闻数据
	public List<News> getPageNewsList(int pageNo,int pageSize);
	
	// 删除新闻标题根据id
	public boolean deleteNews(News news);

}
